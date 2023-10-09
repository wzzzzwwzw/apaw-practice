package es.upm.miw.apaw_practice.adapters.rest.film;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.film.FilmResource.FILMS;
import static es.upm.miw.apaw_practice.adapters.rest.film.FilmResource.ID_ID;

@RestTestConfig
class FilmResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(FILMS + ID_ID, "kk")
                .exchange()
                .expectStatus().isNotFound();
    }
}
