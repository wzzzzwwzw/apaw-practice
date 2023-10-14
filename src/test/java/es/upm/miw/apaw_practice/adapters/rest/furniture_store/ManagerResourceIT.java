package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.furniture_store.ManagerResource.MANAGER;
import static es.upm.miw.apaw_practice.adapters.rest.furniture_store.ManagerResource.NAME_ID;


@RestTestConfig
class ManagerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(MANAGER + NAME_ID, "José")
                .exchange()
                .expectStatus().isOk();
    }
}
