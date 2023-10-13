package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.MuseumSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import es.upm.miw.apaw_practice.domain.models.museum.Painter;
import es.upm.miw.apaw_practice.domain.models.museum.Room;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class PainterResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private MuseumSeederService museumSeederService;

    @BeforeEach
    void resetDataBase() {
        this.museumSeederService.deleteAll();
        this.museumSeederService.seedDatabase();
    }

    /*
new PainterEntity("Francisco de", "Goya y Lucientes", LocalDate.of(1746, 3, 30), LocalDate.of(1828, 4, 16), List.of(artWorks[2], artWorks[3], artWorks[6])),
new PainterEntity("Diego Rodríguez de Silva y", "Velázquez", LocalDate.of(1599, 6, 6), LocalDate.of(1660, 8, 6), List.of(artWorks[0], artWorks[4], artWorks[8])),
new PainterEntity("Jheronimus van Aken, el", "Bosco", LocalDate.of(1450, 1, 1), LocalDate.of(1516, 1, 1), List.of(artWorks[1])),
new PainterEntity("Pedro Pablo", "Rubens", LocalDate.of(1577, 6, 28), LocalDate.of(1640, 5, 30), List.of(artWorks[5])),
new PainterEntity("Fra", "Angelico", LocalDate.of(1395, 1, 1), LocalDate.of(1455, 2, 18), List.of(artWorks[7])),
     */


    @Test
    void testFindNamesByArtWorkInRoomFloorGreaterThan() {
        Map<Integer, Set<String>> expectedResults = new HashMap<>() {{
            put(-1, Set.of("Diego Rodríguez de Silva y", "Fra", "Francisco de", "Jheronimus van Aken, el", "Pedro Pablo"));
            put(0, Set.of("Diego Rodríguez de Silva y", "Francisco de", "Pedro Pablo"));
            put(1, Set.of());
        }};

        expectedResults.forEach((key, value) ->
                this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PainterResource.PAINTERS + PainterResource.SEARCH)
                        .queryParam("q", "floor:" + key)
                        .build())
                .exchange()
                .expectBody(new ParameterizedTypeReference<List<String>>() {})
                .consumeWith(entityList -> {
                    assertNotNull(entityList.getResponseBody());
                    assertEquals(value, Set.copyOf(entityList.getResponseBody()));
                })
        );
    }

    @Test
    void testUpdate() {
        Room room = new Room().builder()
                .description("Sala 012")
                .floor(1)
                .popularity(9.75)
                .build();
        ArtWork artWork = new ArtWork().builder()
                .inventoryNumber("P001174")
                .title("Las Meninas")
                .approximateYear(1656)
                .exhibited(true)
                .room(room)
                .build();
        Painter painter = new Painter("Diego", "Velázquez", LocalDate.of(1599, 6, 6), LocalDate.of(1660, 8, 6), List.of(artWork));

        this.webTestClient
                .put()
                .uri(PainterResource.PAINTERS + PainterResource.SURNAME_ID, "Velázquez")
                .body(BodyInserters.fromValue(painter))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Painter.class)
                .value(Assertions::assertNotNull)
                .value(response -> assertEquals(painter.getName(), response.getName()))
                .value(response -> assertEquals(painter.getSurname(), response.getSurname()))
                .value(response -> assertEquals(painter.getBirthDate(), response.getBirthDate()))
                .value(response -> assertEquals(painter.getDeathDate(), response.getDeathDate()))
                .value(response -> assertEquals(painter.getArtWorks().size(), response.getArtWorks().size()))
                .value(response -> assertEquals(painter.getArtWorks().get(0).getInventoryNumber(), response.getArtWorks().get(0).getInventoryNumber()));
    }

    @Test
    void testBadUpdate() {
        Room room = new Room().builder()
                .description("Sala 012")
                .floor(1)
                .popularity(9.75)
                .build();
        ArtWork artWork = new ArtWork().builder()
                .inventoryNumber("P001174")
                .title("Las Meninas")
                .approximateYear(1656)
                .exhibited(true)
                .room(room)
                .build();
        Painter painter = new Painter("Diego", "Velázquez (con otro apellido)", LocalDate.of(1599, 6, 6), LocalDate.of(1660, 8, 6), List.of(artWork));

        this.webTestClient
                .put()
                .uri(PainterResource.PAINTERS + PainterResource.SURNAME_ID, "Velázquez")
                .body(BodyInserters.fromValue(painter))
                .exchange()
                .expectStatus().isNotFound();
    }
}
