package es.upm.miw.apaw_practice.adapters.rest.car_workshop;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.CarWorkshopSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;
import org.junit.jupiter.api.AfterEach;
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

    @Autowired
    private CarWorkshopSeederService carWorkshopSeederService;

    @AfterEach
    void resetDataBase() {
        this.carWorkshopSeederService.deleteAll();
        this.carWorkshopSeederService.seedDatabase();
    }

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

    @Test
    void testGetTotalStock() {
        this.webTestClient
                .get()
                .uri(CarComponentResource.CARCOMPONENTS + CarComponentResource.SEARCHSTOCK + "?q=isITVSafe:true")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Integer.class)
                .value(stock -> assertEquals(stock, 11300));

        this.webTestClient
                .get()
                .uri(CarComponentResource.CARCOMPONENTS + CarComponentResource.SEARCHSTOCK + "?q=isITVSafe:false")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Integer.class)
                .value(stock -> assertEquals(stock, 1300));
    }
    @Test
    void testGetTotalStockMalformed() {
        this.webTestClient
                .get()
                .uri(CarComponentResource.CARCOMPONENTS + CarComponentResource.SEARCHSTOCK + "?q=isITVSafe:HAHAHA")
                .exchange()
                .expectStatus().isBadRequest();
    }
}
