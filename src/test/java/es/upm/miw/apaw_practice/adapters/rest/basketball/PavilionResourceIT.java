package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.BasketballSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class PavilionResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private BasketballSeederService basketballSeederService;
    @BeforeEach
    void resetDataBase() {
        this.basketballSeederService.deleteAll();
        this.basketballSeederService.seedDatabase();
    }


    @Test
    void testPostPavilion() {
        Pavilion pavilion = new Pavilion("pavilion3", "location1", 40);
        this.webTestClient
                .post()
                .uri(PavilionResource.PAVILION)
                .body(BodyInserters.fromValue(pavilion))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Pavilion.class)
                .value(Assertions::assertNotNull)
                .value(pav -> {
                    assertEquals("pavilion3", pav.getPavname());
                    assertEquals("location1", pav.getDirection());
                    assertEquals(40, pav.getCapacity());
                });
    }

    @Test
    void testfindAvgOfTotalCapacityByBasketValue() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(PavilionResource.PAVILION + PavilionResource.SEARCH)
                                .queryParam("q", "value:3")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(Assertions::assertNotNull)
                .value(avgCapacity ->
                        assertEquals(0, new BigDecimal("1500.00").compareTo(avgCapacity))
                );
    }
}