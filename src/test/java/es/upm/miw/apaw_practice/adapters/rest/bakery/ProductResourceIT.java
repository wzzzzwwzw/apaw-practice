package es.upm.miw.apaw_practice.adapters.rest.bakery;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.BakerySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.bakery.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    @Test
    void testUpdatePrice() {
        Product expectedProduct = new Product("Pan integral", "Nuestro pan integral", new BigDecimal("900.10"), true,
                LocalDate.of(2023, 1, 1), null);
        String newPrice = "900.10";
        this.webTestClient
                .patch()
                .uri(ProductResource.PRODUCTS + ProductResource.NAME_ID, "Pan integral")
                .body(BodyInserters.fromValue(newPrice))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Product.class)
                .value(product -> {
                    assertNotNull(product);
                    assertEquals(expectedProduct.getName(), product.getName());
                    assertEquals(expectedProduct.getDescription(), product.getDescription());
                    assertEquals(expectedProduct.getPrice(), product.getPrice());
                    assertEquals(expectedProduct.isGlutenFree(), product.isGlutenFree());
                    assertEquals(expectedProduct.getExpirationDate(), product.getExpirationDate());
                });
    }
}