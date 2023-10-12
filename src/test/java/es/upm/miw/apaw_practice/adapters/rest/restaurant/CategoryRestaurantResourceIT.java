package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.restaurant.CategoryRestaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class CategoryRestaurantResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        CategoryRestaurant categoryRestaurant =
                new CategoryRestaurant("Ensaladas", "Verde oscuro");
        this.webTestClient
                .post()
                .uri(CategoryRestaurantResource.CATEGORIES)
                .body(BodyInserters.fromValue(categoryRestaurant))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CategoryRestaurant.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testCreateConfict() {
        CategoryRestaurant categoryRestaurant =
                new CategoryRestaurant("Carne", "Azul");
        this.webTestClient
                .post()
                .uri(CategoryRestaurantResource.CATEGORIES)
                .body(BodyInserters.fromValue(categoryRestaurant))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

}
