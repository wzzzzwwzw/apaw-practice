package es.upm.miw.apaw_practice.adapters.rest.stable;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.stable.Horse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class HorseResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSearchByProviderAndPriceGreaterThan() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(HorseResource.STABLES + HorseResource.SEARCH)
                                .queryParam("q", "price:12000")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Horse.class)
                .value(horses -> assertFalse(horses.isEmpty()))
                .value(horses -> assertTrue(new BigDecimal("12000.0").compareTo(horses.get(0).getPurchasePrice()) < 0))
                .value(horses -> assertEquals("name3", horses.get(0).getName()))
                .value(horses -> assertEquals("name4", horses.get(1).getName()));
    }
}
