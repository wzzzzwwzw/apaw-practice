package es.upm.miw.apaw_practice.adapters.rest.film;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.film.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.stream.Stream;

import static es.upm.miw.apaw_practice.adapters.rest.film.FilmResource.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
class FilmResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(FILMS + TITLE_ID, "Gladiator")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Film.class)
                .consumeWith(films -> {
                    assertNotNull(films.getResponseBody());
                    Film film = films.getResponseBody().get(0);
                    assertEquals("Synopsis 3", film.getSynopsis());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(FILMS + TITLE_ID, "None")
                .exchange()
                .expectStatus().isNotFound();
    }
}
