package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDate;

import static es.upm.miw.apaw_practice.adapters.rest.car_dealership.CarResource.*;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class CarResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadCarModelName() {
        this.webTestClient
                .get()
                .uri(CARS + CHASSIS_ID + CAR_MODEL + NAME, "HV30-0169266692781")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(Assertions::assertNotNull)
                .value(modelNameData -> {
                    assertEquals("Camry", modelNameData);
                });
    }

    @Test
    void testReadCarModelNameNotFound() {
        this.webTestClient
                .get()
                .uri(CARS + CHASSIS_ID + CAR_MODEL + NAME, "0")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindAverageCarPriceByName () {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(CARS + SEARCH)
                                .queryParam("q", "name:Asier")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(Assertions::assertNotNull)
                .value(average -> assertEquals(0, new BigDecimal("29466.66").compareTo(average)));
    }

    @Test
    void testFindAverageCarPriceByNameBadRequest () {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(CARS + SEARCH)
                                .queryParam("q", "na:NaN")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }
}
