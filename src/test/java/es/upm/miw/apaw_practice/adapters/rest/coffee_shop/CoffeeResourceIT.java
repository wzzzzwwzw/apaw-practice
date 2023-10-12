package es.upm.miw.apaw_practice.adapters.rest.coffee_shop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

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
}
