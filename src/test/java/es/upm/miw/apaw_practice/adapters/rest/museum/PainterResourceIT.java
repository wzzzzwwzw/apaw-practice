package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import es.upm.miw.apaw_practice.domain.models.museum.Painter;
import es.upm.miw.apaw_practice.domain.models.museum.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class PainterResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdate() {
        ArtWork[] artWorks = {
                new ArtWork("P001174", "Las Meninas", 1656, true, new Room("Sala 012", 1, 9.75))
        };
        Painter painter = new Painter("Diego", "Velázquez", LocalDate.of(1599, 6, 6), LocalDate.of(1660, 8, 6), List.of(artWorks));

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
        ArtWork[] artWorks = {
                new ArtWork("P001174", "Las Meninas", 1656, true, new Room("Sala 012", 1, 9.75))
        };
        Painter painter = new Painter("Diego", "Velázquez (con otro apellido)", LocalDate.of(1599, 6, 6), LocalDate.of(1660, 8, 6), List.of(artWorks));

        this.webTestClient
                .put()
                .uri(PainterResource.PAINTERS + PainterResource.SURNAME_ID, "Velázquez")
                .body(BodyInserters.fromValue(painter))
                .exchange()
                .expectStatus().isNotFound();
    }
}
