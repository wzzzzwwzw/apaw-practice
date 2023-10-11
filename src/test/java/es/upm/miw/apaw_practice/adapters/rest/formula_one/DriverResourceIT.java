package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class DriverResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdatePoints() {
        this.webTestClient
                .patch()
                .uri(DriverResource.DRIVERS + DriverResource.NUMBER_ID, 14)
                .body(BodyInserters.fromValue(100F))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdatePointsNotFound() {
        this.webTestClient
                .patch()
                .uri(DriverResource.DRIVERS + DriverResource.NUMBER_ID, 100)
                .body(BodyInserters.fromValue(100F))
                .exchange()
                .expectStatus().isNotFound();
    }
}
