package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.MuseumSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
