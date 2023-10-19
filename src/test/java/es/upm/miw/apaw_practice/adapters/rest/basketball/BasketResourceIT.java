package es.upm.miw.apaw_practice.adapters.rest.basketball;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.BodyInserters;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RestTestConfig
class BasketResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdate() {
        Integer newValue = 1;
        this.webTestClient
                .patch()
                .uri(BasketResource.BASKET + BasketResource.ID + BasketResource.UPDATE_DATA, "canasta1")
                .body(BodyInserters.fromValue(newValue))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Basket.class)
                .value(Assertions::assertNotNull)
                .value(basket -> {
                    assertEquals(1, basket.getValue());
                });
    }
}
