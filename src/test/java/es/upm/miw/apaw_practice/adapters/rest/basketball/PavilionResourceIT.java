package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.BodyInserters;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class PavilionResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testPostPavilion() {
        Pavilion pavilion = new Pavilion("pavilion3","location1",40);
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
}    