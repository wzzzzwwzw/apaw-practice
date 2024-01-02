package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.AirportSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
@RestTestConfig
public class AirLineResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private AirportSeederService airportSeederService;
    @AfterEach
    void resetDataBase() {
        this.airportSeederService.deleteAll();
        this.airportSeederService.seedDatabase();
    }
    @Test
    void testUpdate() {
        List<Aircraft> aircraftList = Arrays.asList(
                new Aircraft(LocalDate.of(2023,1,12), 520, "Boeing 474","231QWE"),
                new Aircraft(LocalDate.of(2023,3,23), 300, "Airbus 420","KKH437")
        );
        this.webTestClient
                .put()
                .uri(AirLineResource.AIRLINES + AirLineResource.NAME + AirLineResource.AIRCRAFTS, "Iberia")
                .body(BodyInserters.fromValue(aircraftList))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateNotFound() {
        List<Aircraft> aircraftList = Arrays.asList(
                new Aircraft(LocalDate.of(2023,1,12), 520, "Boeing 474","231QWE"),
                new Aircraft(LocalDate.of(2023,3,23), 300, "Airbus 420","KKH437")
        );
        this.webTestClient
                .put()
                .uri(AirLineResource.AIRLINES + AirLineResource.NAME + AirLineResource.AIRCRAFTS, "British Airways")
                .body(BodyInserters.fromValue(aircraftList))
                .exchange()
                .expectStatus().isNotFound();
    }
}
