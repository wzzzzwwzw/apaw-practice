package es.upm.miw.apaw_practice.adapters.rest.film;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.film.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;

import static es.upm.miw.apaw_practice.adapters.rest.film.DirectorResource.DIRECTORS;
import static es.upm.miw.apaw_practice.adapters.rest.film.DirectorResource.DNI_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class DirectorResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Director director =
                new Director("35469251P", "Luis", "Garcia", LocalDate.of(1999, 5, 29));
        this.webTestClient
                .post()
                .uri(DIRECTORS)
                .body(BodyInserters.fromValue(director))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Director.class)
                .value(Assertions::assertNotNull)
                .value(director1 -> {
                    assertEquals(director.getName(), director1.getName());
                    assertEquals(director.getDni(), director1.getDni());
                    assertEquals(director.getDateOfBirth(), director1.getDateOfBirth());
                });
    }

    @Test
    void testCreateConflict() {
        Director director =
                new Director("12258468Y", "Luis", "Garcia", LocalDate.of(1999, 5, 29));
        this.webTestClient
                .post()
                .uri(DIRECTORS)
                .body(BodyInserters.fromValue(director))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testUpdateSurname() {
        String surname = "Ruiz";
        this.webTestClient
                .patch()
                .uri(DIRECTORS + DNI_ID, "12258468Y")
                .body(BodyInserters.fromValue(surname))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Director.class)
                .value(Assertions::assertNotNull)
                .value(director -> {
                    assertEquals("Ruiz", director.getSurname());
                });
    }

    @Test
    void testUpdateSurnameNotFound() {
        String surname = "Ruiz";
        this.webTestClient
                .patch()
                .uri(DIRECTORS + DNI_ID, "00000000Z")
                .body(BodyInserters.fromValue(surname))
                .exchange()
                .expectStatus().isNotFound();
    }
}
