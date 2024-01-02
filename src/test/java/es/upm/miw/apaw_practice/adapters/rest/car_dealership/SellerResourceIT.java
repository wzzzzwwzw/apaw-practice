package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;

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
        String newName = "NewName";
        this.webTestClient.put()
                .uri(SellerResource.SELLERS + SellerResource.ID_ID + SellerResource.NAME, "NaN")
                .body(BodyInserters.fromValue(newName))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testPatchNotFound() {
        String newSurname = "NewSurname";
        this.webTestClient.patch()
                .uri(SellerResource.SELLERS + SellerResource.ID_ID, "NaN")
                .body(BodyInserters.fromValue(newSurname))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindUniqueSurnamesMore20000ByBrand() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(SellerResource.SELLERS + SellerResource.SEARCH)
                                .queryParam("q", "brand:Toyota")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(surnames -> assertFalse(surnames.isEmpty()))
                .value(surnames -> assertTrue(surnames.get(0).contains("Gonzalez")))
                .value(surnames -> assertTrue(surnames.get(0).contains("Fernandez")))
                .value(surnames -> assertTrue(surnames.get(0).contains("Bosque")));
    }

    @Test
    void testFindUniqueSurnamesMore20000ByBrandBadRequest() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(SellerResource.SELLERS + SellerResource.SEARCH)
                                .queryParam("q", "br:NaN")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }
}
