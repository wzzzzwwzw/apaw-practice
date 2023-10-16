package es.upm.miw.apaw_practice.adapters.rest.influencer_agency;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
class AgencyResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDeleteAgenciesStartingWithGivenPrefix() {
        this.webTestClient
                .delete()
                .uri(AgencyResource.AGENCIES + AgencyResource.NAME_ID, "a")
                .exchange()
                .expectStatus().isOk();
    }
}