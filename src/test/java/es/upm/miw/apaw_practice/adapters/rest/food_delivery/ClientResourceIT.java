package es.upm.miw.apaw_practice.adapters.rest.food_delivery;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.food_delivery.ClientResource.CLIENTS;
import static es.upm.miw.apaw_practice.adapters.rest.food_delivery.ClientResource.IDENTITY_ID;

@RestTestConfig
class ClientResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDeleteNotFound(){
        this.webTestClient
                .delete()
                .uri(CLIENTS + IDENTITY_ID,"ID004")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testDelete(){
        this.webTestClient
                .delete()
                .uri(CLIENTS + IDENTITY_ID,"ID003")
                .exchange()
                .expectStatus().isOk();
    }

}
