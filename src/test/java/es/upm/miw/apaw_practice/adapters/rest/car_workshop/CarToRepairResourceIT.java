package es.upm.miw.apaw_practice.adapters.rest.car_workshop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.car_workshop.CarToRepair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class CarToRepairResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateModel() {
        this.webTestClient
                .put()
                .uri(CarToRepairResource.CARSTOREPAIR + CarToRepairResource.REGISTRATIONNUMBER_ID + CarToRepairResource.MODEL, "7687FDR")
                .body(BodyInserters.fromValue("Duster"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CarToRepair.class)
                .value(Assertions::assertNotNull)
                .value(carToRepair -> {
                    assertEquals(carToRepair.getRegistrationNumber(), "7687FDR");
                    assertEquals(carToRepair.getModel(), "Duster");
                });
    }

    @Test
    void testUpdateWithNoExistingCar() {
        this.webTestClient
                .put()
                .uri(CarToRepairResource.CARSTOREPAIR + CarToRepairResource.REGISTRATIONNUMBER_ID + CarToRepairResource.MODEL, "nonexistinglol")
                .body(BodyInserters.fromValue("Duster"))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }
}
