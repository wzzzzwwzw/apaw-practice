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
        String registrationNumber = "7687FDR";
        String newModel = "Duster";
        this.webTestClient
                .put()
                .uri(CarToRepairResource.CARSTOREPAIR + CarToRepairResource.REGISTRATIONNUMBER_ID + CarToRepairResource.MODEL, registrationNumber)
                .body(BodyInserters.fromValue(newModel))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CarToRepair.class)
                .value(Assertions::assertNotNull)
                .value(carToRepair -> {
                    assertEquals(carToRepair.getRegistrationNumber(), registrationNumber);
                    assertEquals(carToRepair.getModel(), newModel);
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
