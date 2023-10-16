package es.upm.miw.apaw_practice.adapters.rest.bakery;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.BakerySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class ProductResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private BakerySeederService bakerySeederService;

    @BeforeEach
    void resetDb() {
        this.bakerySeederService.deleteAll();
        this.bakerySeederService.seedDatabase();
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(ProductResource.PRODUCTS + ProductResource.NAME_ID, "Pan integral")
                .exchange()
                .expectStatus().isOk();
    }
}