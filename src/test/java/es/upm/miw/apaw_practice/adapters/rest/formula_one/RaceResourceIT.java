package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static es.upm.miw.apaw_practice.adapters.rest.formula_one.RaceResource.CIRCUIT_NAME_ID;
import static es.upm.miw.apaw_practice.adapters.rest.formula_one.RaceResource.RACES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class RaceResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testFindByCircuitName() {
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
    void testFindByCircuitNameNotFound() {
        this.webTestClient
                .get()
                .uri(RACES + CIRCUIT_NAME_ID, "Imola")
                .exchange()
                .expectStatus().isNotFound();
    }
}
