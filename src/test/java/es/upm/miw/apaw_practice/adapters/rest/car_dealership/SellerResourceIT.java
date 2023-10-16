package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class SellerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Seller seller = new Seller("Name", "Surname", 2000);
        this.webTestClient.post()
                .uri(SellerResource.SELLERS)
                .body(BodyInserters.fromValue(seller))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Seller.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testUpdateNotFound() {
        String newName = "Igor";
        this.webTestClient.put()
                .uri(SellerResource.SELLERS + SellerResource.ID_ID + SellerResource.NAME, "kk")
                .body(BodyInserters.fromValue(newName))
                .exchange()
                .expectStatus().isNotFound();
    }
}
