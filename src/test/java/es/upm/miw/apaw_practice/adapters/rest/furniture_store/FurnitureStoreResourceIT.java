package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.furniture_store.FurnitureStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.furniture_store.FurnitureStoreResource.*;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class FurnitureStoreResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(FURNITURE_STORE + NAME_ID, "ikia")
                .exchange()
                .expectStatus().isOk()
                .expectBody(FurnitureStore.class)
                .value(Assertions::assertNotNull)
                .value(furnitureStoreData -> {;
                    assertEquals(3, furnitureStoreData.getFurnitures().size());
                    assertEquals("María", furnitureStoreData.getManager().getName());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(FURNITURE_STORE + NAME_ID, "None")
                .exchange()
                .expectStatus().isNotFound();
    }
}
