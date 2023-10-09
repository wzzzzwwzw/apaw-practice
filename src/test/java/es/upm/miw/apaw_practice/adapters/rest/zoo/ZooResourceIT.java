package es.upm.miw.apaw_practice.adapters.rest.zoo;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.ZooPriceUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@RestTestConfig
public class ZooResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(ZooResource.ZOO + ZooResource.NAME_ID, "ZOO MADRID")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdatePrices() {
        List<ZooPriceUpdating> zooPriceUpdating = Arrays.asList(
                new ZooPriceUpdating("FAUNIA", new BigDecimal(50)),
                new ZooPriceUpdating("PROTECTORA CANINA", new BigDecimal(0))
        );
        this.webTestClient
                .patch()
                .uri(ZooResource.ZOO)
                .body(BodyInserters.fromValue(zooPriceUpdating))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdatePricesNotFound() {
        List<ZooPriceUpdating> zooPriceUpdating = List.of(
                new ZooPriceUpdating("FAUNOOO", new BigDecimal(50))
        );
        this.webTestClient
                .patch()
                .uri(ZooResource.ZOO)
                .body(BodyInserters.fromValue(zooPriceUpdating))
                .exchange()
                .expectStatus().isNotFound();
    }
}
