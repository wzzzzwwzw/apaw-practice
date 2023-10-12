package es.upm.miw.apaw_practice.adapters.rest.conference;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
class ConferenceResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient.delete()
                .uri(ConferenceResource.CONFERENCES + ConferenceResource.ID_ID, "NaN")
                .exchange()
                .expectStatus().isOk();
    }
}
