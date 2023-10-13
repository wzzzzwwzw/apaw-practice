package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static es.upm.miw.apaw_practice.adapters.rest.formula_one.DriverResource.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class DriverResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdatePoints() {
        this.webTestClient
                .patch()
                .uri(DRIVERS + NUMBER_ID, 14)
                .body(BodyInserters.fromValue(100F))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdatePointsNotFound() {
        this.webTestClient
                .patch()
                .uri(DRIVERS + NUMBER_ID, 100)
                .body(BodyInserters.fromValue(100F))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindTotalPointsByEnginesBuiltIn() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(DRIVERS + SEARCH)
                                .queryParam("q", "enginesBuiltIn:Japan")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Float.class)
                .value(points -> assertEquals(332.5F, points));
    }

    @Test
    void testNotFindTotalPointsByEnginesBuiltIn() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(DRIVERS + SEARCH)
                                .queryParam("q", "enginesBuiltIn:Portugal")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Float.class)
                .value(points -> assertEquals(0F, points));
    }

    @Test
    void testFindTotalPointsByEnginesBuiltInBadRequest() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(DRIVERS + SEARCH)
                                .queryParam("q", "enginesBuiltI:China")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }

}
