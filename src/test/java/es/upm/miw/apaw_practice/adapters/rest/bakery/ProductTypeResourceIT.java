package es.upm.miw.apaw_practice.adapters.rest.bakery;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.BakerySeederService;
import es.upm.miw.apaw_practice.domain.models.bakery.ProductType;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class ProductTypeResourceIT {

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
    void testGetByCode() {
        ProductType expectedProductType = new ProductType("Salados", "Nuestra variedad de salados", "SALS");
        this.webTestClient
                .get()
                .uri(ProductTypeResource.PRODUCT_TYPES + ProductTypeResource.CODE_ID, "SALS")
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductType.class)
                .value(productType -> {
                    assertNotNull(productType);
                    assertEquals(expectedProductType.getName(), productType.getName());
                    assertEquals(expectedProductType.getDescription(), productType.getDescription());
                    assertEquals(expectedProductType.getCode(), productType.getCode());
                });
    }
}