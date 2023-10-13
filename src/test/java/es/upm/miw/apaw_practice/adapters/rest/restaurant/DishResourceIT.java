package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.RestaurantSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class DishResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private RestaurantSeederService restaurantSeederService;

    @BeforeEach
    void cleanUpDb() {
        this.restaurantSeederService.deleteAll();
        this.restaurantSeederService.seedDatabase();
    }

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

    @Test
    void testIncreasePrices() {
        Float increment = 2f;

        this.webTestClient
                .patch()
                .uri(DishResource.DISHES)
                .body(BodyInserters.fromValue(increment))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindSumOfPriceByAvailableAndLastModificationThisMonth() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(DishResource.DISHES + DishResource.SEARCH)
                                .queryParam("q", "available:true")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(Assertions::assertNotNull)
                .value(cost -> assertEquals(new BigDecimal("13.5"), cost));


    }

}
