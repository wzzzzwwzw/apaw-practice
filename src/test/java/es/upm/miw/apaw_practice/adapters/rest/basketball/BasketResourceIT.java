package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.bson.assertions.Assertions.assertNotNull;
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


    @Test
    void testFindIdentifiersByPavilionDirection() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(BasketResource.BASKET + BasketResource.SEARCH)
                                .queryParam("q", "direction:direction1")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(identifiersList -> {
                    assertNotNull(identifiersList);
                    assertTrue(identifiersList.contains("[\"canasta1\",\"canasta2\"]"));
                });
    }
}
