package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.basketball.PlayerResource.EMAIL_ID;
import static es.upm.miw.apaw_practice.adapters.rest.basketball.PlayerResource.PLAYER;

@RestTestConfig
class PlayerResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(PLAYER + EMAIL_ID, "email3@gmail.com")
                .exchange()
                .expectStatus().isOk();
    }
}
