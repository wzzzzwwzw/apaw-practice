package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static es.upm.miw.apaw_practice.adapters.rest.furniture_store.ManagerResource.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class ManagerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(MANAGERS + AFFILIATION_NUMBER_ID, "No existe")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateName() {
        String surname = "Roberto";
        this.webTestClient
                .patch()
                .uri(MANAGERS + AFFILIATION_NUMBER_ID, "123456789012")
                .body(BodyInserters.fromValue(surname))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Manager.class)
                .value(Assertions::assertNotNull)
                .value(manager -> assertEquals("Roberto", manager.getName()));
    }
}
