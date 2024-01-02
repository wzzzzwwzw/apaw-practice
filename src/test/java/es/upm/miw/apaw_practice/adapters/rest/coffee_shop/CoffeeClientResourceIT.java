package es.upm.miw.apaw_practice.adapters.rest.coffee_shop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.CoffeeClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RestTestConfig
public class CoffeeClientResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDeleteEndpoint() {
        this.webTestClient
                .delete()
                .uri(CoffeeClientResource.COFFEES + CoffeeClientResource.NAME, "client1")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testPatchEndpoint() {
        this.webTestClient
                .patch()
                .uri(CoffeeClientResource.COFFEES + CoffeeClientResource.NAME, "client3")
                .exchange()
                .expectStatus().isOk()
                .expectBody(CoffeeClient.class)
                .value(Assertions::assertNotNull)
                .value(coffeeClient -> {
                    assertEquals("new address", coffeeClient.getAddress());
                });
    }

    @Test
    void testGetTotalPriceByCategory() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(CoffeeClientResource.COFFEES + CoffeeClientResource.TOTAL_PRICE)
                .queryParam("q", "category:Tea")
                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(totalPrice -> {
                    assertEquals(new BigDecimal("60.00"), totalPrice);
                });
    }

    @Test
    void testGetUniqueLocationsByCoffee() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(CoffeeClientResource.COFFEES + CoffeeClientResource.UNIQUE_LOCATION)
                                .queryParam("q", "coffee:Expresso Frappuccino")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(UniqueLocationsByCoffeeList -> {
                    assertEquals(List.of("location4"), UniqueLocationsByCoffeeList);
                });
    }
}
