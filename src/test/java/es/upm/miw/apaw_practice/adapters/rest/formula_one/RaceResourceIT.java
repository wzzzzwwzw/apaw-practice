package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;

import static es.upm.miw.apaw_practice.adapters.rest.formula_one.RaceResource.*;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class RaceResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(RACES + CIRCUIT_NAME_ID, "Albert Park")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Race.class)
                .value(Assertions::assertNotNull)
                .value(race -> {
                    assertEquals("Albert Park", race.getCircuitName());
                    assertEquals("Australia", race.getHostCountry());
                    assertEquals(LocalDate.of(2023, 4, 2), race.getDate());
                    assertTrue(
                            race.getRaceDrivers().stream()
                                    .anyMatch(driver ->
                                            driver.getDriverName().equals("Lance Stroll") &&
                                                    driver.getNumber() == 18 &&
                                                    driver.getNationality().equals("Canada")
                                    )
                    );
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(RACES + CIRCUIT_NAME_ID, "Imola")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdateLaps() {
        this.webTestClient
                .put()
                .uri(RACES + CIRCUIT_NAME_ID + LAPS, "Hermanos Rodríguez")
                .body(BodyInserters.fromValue(71))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Race.class)
                .value(race -> {
                    assertNotNull(race);
                    assertEquals("Hermanos Rodríguez", race.getCircuitName());
                    assertEquals(71, race.getLaps());
                });
    }

    @Test
    void testUpdateLapsNotFound() {
        this.webTestClient
                .put()
                .uri(RACES + CIRCUIT_NAME_ID + LAPS, "Imola")
                .body(BodyInserters.fromValue(63))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }
}
