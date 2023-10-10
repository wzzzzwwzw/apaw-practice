package es.upm.miw.apaw_practice.adapters.rest.film;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.film.GenreResource.GENRES;
import static es.upm.miw.apaw_practice.adapters.rest.film.GenreResource.NAME_ID;

@RestTestConfig
class GenreResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(GENRES + NAME_ID, "Action")
                .exchange()
                .expectStatus().isOk();
    }
}
