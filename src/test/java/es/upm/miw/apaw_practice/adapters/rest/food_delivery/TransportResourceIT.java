package es.upm.miw.apaw_practice.adapters.rest.food_delivery;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class TransportResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdate(){
        this.webTestClient
                .put()
                .uri(TransportResource.TRANSPORTS + TransportResource.CODE_ID + TransportResource.AVALAIBLE, "T002")
                .body(BodyInserters.fromValue(false))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateNotFound(){
        this.webTestClient
                .put()
                .uri(TransportResource.TRANSPORTS + TransportResource.CODE_ID + TransportResource.AVALAIBLE, "T004")
                .body(BodyInserters.fromValue(false))
                .exchange()
                .expectStatus().isNotFound();
    }
}


