package es.upm.miw.apaw_practice.adapters.rest.coffee_shop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class CoffeeClientResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDeleteEndpoint() {
        this.webTestClient
                .delete()
                .uri(CoffeeClientResource.COFFEES + CoffeeClientResource.NAME, "client1")
                .exchange()
                .expectStatus().isOk();
    }
}
