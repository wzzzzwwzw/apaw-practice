package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static es.upm.miw.apaw_practice.adapters.rest.airport.PassengerResource.*;

@RestTestConfig
public class PassengerResourceIT {
    @Autowired
    private WebTestClient webTestClient;


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

}
