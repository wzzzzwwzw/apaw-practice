package es.upm.miw.apaw_practice.adapters.rest.car_workshop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class CarComponentResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        CarComponent carComponent = new CarComponent("Steering Wheel", new BigDecimal("20.0"), 100);
        this.webTestClient
                .post()
                .uri(CarComponentResource.CARCOMPONENTS)
                .body(BodyInserters.fromValue(carComponent))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CarComponent.class)
                .value(Assertions::assertNotNull)
                .value(carComponent1 -> assertEquals(carComponent1.getName(), carComponent.getName()));
    }

    @Test
    void testCreateWithConflict() {
        CarComponent repeatedCarComponent = new CarComponent("Universal Belt", new BigDecimal("20.0"), 100);
        this.webTestClient
                .post()
                .uri(CarComponentResource.CARCOMPONENTS)
                .body(BodyInserters.fromValue(repeatedCarComponent))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
