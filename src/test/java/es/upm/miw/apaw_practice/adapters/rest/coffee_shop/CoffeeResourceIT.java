package es.upm.miw.apaw_practice.adapters.rest.coffee_shop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.util.UriUtils;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RestTestConfig
public class CoffeeResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetByName() {
        this.webTestClient
                .get()
                .uri(CoffeeResource.COFFEES + CoffeeResource.NAME, "caffé americano")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Coffee.class)
                .value(Assertions::assertNotNull)
                .value(coffee -> {
                    assertEquals("caffé americano", coffee.getCoffee());
                    assertEquals("Espresso & Classic",coffee.getCategory());
                    assertEquals(new BigDecimal("5.00"),coffee.getPrice());
                });
    }

    @Test
    void testUpdate() {
        this.webTestClient
                .put()
                .uri(CoffeeResource.COFFEES + CoffeeResource.NAME + CoffeeResource.UPDATE_DATA, "Mocha Frappuccino")
                .body(BodyInserters.fromValue(new BigDecimal("6.50")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Coffee.class)
                .value(Assertions::assertNotNull)
                .value(coffee -> {
                    assertEquals(new BigDecimal("6.50"), coffee.getPrice());
                });
    }
}
