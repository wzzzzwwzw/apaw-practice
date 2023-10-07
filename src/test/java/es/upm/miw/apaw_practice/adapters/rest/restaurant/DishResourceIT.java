package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

@RestTestConfig
public class DishResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdate() {
        BigDecimal price = new BigDecimal("12.5");

        this.webTestClient
                .put()
                .uri(DishResource.DISHES + DishResource.TITLE_ID + DishResource.PRICE, "Pollo_con_patatas")
                .body(BodyInserters.fromValue(price))
                .exchange()
                .expectStatus().isOk();
    }

}
