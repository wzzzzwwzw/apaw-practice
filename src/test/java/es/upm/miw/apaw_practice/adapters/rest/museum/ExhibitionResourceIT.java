package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.MuseumSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class ExhibitionResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private MuseumSeederService museumSeederService;

    @BeforeEach
    void resetDataBase() {
        this.museumSeederService.deleteAll();
        this.museumSeederService.seedDatabase();
    }

    @Test
    void testFindLocationsByArtWorkExhibitedOfPainterBySurname() {
        Map<String, Set<String>> expectedResults = new HashMap<>() {{
            put("Velázquez", Set.of("Museo Nacional del Prado (Madrid, España)"));
            put("Goya y Lucientes", Set.of("CaixaForum (Barcelona, España)"));
            put("Bosco", Set.of());
            put("Rubens", Set.of("Museo Nacional del Prado (Madrid, España)"));
            put("Angelico", Set.of("Museo Nacional del Prado (Madrid, España)"));
        }};

        expectedResults.forEach((key, value) ->
            this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(ExhibitionResource.EXHIBITIONS + ExhibitionResource.SEARCH)
                        .queryParam("q", "surname:" + key)
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
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(ExhibitionResource.EXHIBITIONS + ExhibitionResource.NAME_ID, "Reencuentro")
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

    @Test
    void testDeleteNotExisting() {
        this.webTestClient
                .delete()
                .uri(ExhibitionResource.EXHIBITIONS + ExhibitionResource.NAME_ID, "Exposición no existente")
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }
}
