package es.upm.miw.apaw_practice.adapters.rest.food_delivery;


import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class RestaurantResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Restaurant restaurant = new Restaurant("Delicious Bites", "Italian", "A cozy Italian restaurant",
                "123 Main Street, Cityville", 50);
        this.webTestClient
                .post()
                .uri(RestaurantResource.RESTAURANTS)
                .body(BodyInserters.fromValue(restaurant))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK)
                 .expectBody(Restaurant.class)
                 .value(Assertions::assertNotNull);
    }

    @Test
    void testCreateRepeatedName(){
        Restaurant restaurant = new Restaurant("Sushi Palace", "Mexican", "Authentic Mexican cuisine",
                "456 Oak Street, Townsville", 40);
        this.webTestClient
                .post()
                .uri(RestaurantResource.RESTAURANTS)
                .body(BodyInserters.fromValue(restaurant))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

}
