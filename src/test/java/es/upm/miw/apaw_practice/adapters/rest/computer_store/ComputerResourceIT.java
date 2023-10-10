package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
class ComputerResourceIT {
    private static final String DELETE_BY_REST_COMPUTER = "Delete by rest computer";
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDeleteEndpoint() {
        this.webTestClient
                .delete()
                .uri(ComputerResource.COMPUTERS + ComputerResource.NAME_ID, DELETE_BY_REST_COMPUTER)
                .exchange()
                .expectStatus().isOk();
    }
}
