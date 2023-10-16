package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.AirportSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static es.upm.miw.apaw_practice.adapters.rest.airport.PassengerResource.*;

@RestTestConfig
public class PassengerResourceIT {
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
    void testRead() {
        this.webTestClient
                .get()
                .uri(PASSENGERS + NAME_ID, "Carmen Moreno")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Passenger.class)
                .value(Assertions::assertNotNull)
                .value(passenger -> {
                    assertEquals("Carmen Moreno", passenger.getName());
                    assertEquals(20, passenger.getAge());
                    assertEquals("6280942123", passenger.getNumberOfPhone());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(PASSENGERS + NAME_ID, "Manuel Turizo")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdate() {
        List<Aircraft> aircraftList = Arrays.asList(
                new Aircraft(LocalDate.of(2023,1,12), 520, "Boeing 474","231QWE"),
                new Aircraft(LocalDate.of(2023,3,23), 300, "Airbus 420","KKH437")
        );
        this.webTestClient
                .patch()
                .uri(PASSENGERS + NAME_ID, "Carmen Moreno")
                .body(BodyInserters.fromValue("676580594"))
                .exchange()
                .expectStatus().isOk();
    }

}
