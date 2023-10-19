package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Furniture;
import es.upm.miw.apaw_practice.domain.models.furniture_store.FurnitureStore;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static es.upm.miw.apaw_practice.adapters.rest.furniture_store.FurnitureStoreResource.*;
import static es.upm.miw.apaw_practice.adapters.rest.furniture_store.MaterialResource.MATERIALS;
import static es.upm.miw.apaw_practice.adapters.rest.furniture_store.MaterialResource.SEARCH;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class FurnitureStoreResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(FURNITURE_STORES + NAME_ID, "ikia")
                .exchange()
                .expectStatus().isOk()
                .expectBody(FurnitureStore.class)
                .value(Assertions::assertNotNull)
                .value(furnitureStoreData -> {
                    assertEquals(3, furnitureStoreData.getFurnitures().size());
                    assertEquals("456745674567", furnitureStoreData.getManager().getAffiliationNumber());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(FURNITURE_STORES + NAME_ID, "None")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdate() {
        Material material1 = new Material("polipropileno", "plástico", 5);
        Material material2 = new Material("aluminio", "metal", 7);

        List<Furniture> furnitureList = Arrays.asList(
                new Furniture("mesa escritorio", new BigDecimal("45"), List.of(material1, material2)),
                new Furniture("armario grande", new BigDecimal("105.99"), List.of())
        );
        this.webTestClient
                .put()
                .uri(FURNITURE_STORES + NAME_ID + FURNITURES, "muebles vintage")
                .body(BodyInserters.fromValue(furnitureList))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testSearchAverageFurniturePriceByManagerName() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(FURNITURE_STORES + SEARCH)
                                .queryParam("q", "name:José")
                                .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(Assertions::assertNotNull)
                .value(decimal -> {
                    assertEquals(new BigDecimal("20.24"), decimal);
                });
    }

}
