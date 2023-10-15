package es.upm.miw.apaw_practice.adapters.rest.fruitshop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Fruit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class FruitResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdate() {
        BigDecimal unitPrice = new BigDecimal("15");
        String type = "Apple";
        this.webTestClient
                .put()
                .uri(FruitResource.FRUITS + FruitResource.TYPE + FruitResource.UNIT_PRICE, type)
                .body(BodyInserters.fromValue(unitPrice))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Fruit.class)
                .value(fruit -> {
                    assertNotNull(fruit);
                    assertEquals(type, fruit.getType());
                    assertEquals(unitPrice, fruit.getUnitPrice());
                });
    }

        @Test
        void testUpdateNotExist() {
            BigDecimal unitPrice = new BigDecimal("5");
            String type ="ssss";
            this.webTestClient
                    .put()
                    .uri(FruitResource.FRUITS + FruitResource.TYPE + FruitResource.UNIT_PRICE, type)
                    .body(BodyInserters.fromValue(unitPrice))
                    .exchange()
                    .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);

        }

    }

