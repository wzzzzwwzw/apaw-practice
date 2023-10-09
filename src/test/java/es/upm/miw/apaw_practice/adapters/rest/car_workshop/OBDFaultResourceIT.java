package es.upm.miw.apaw_practice.adapters.rest.car_workshop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class OBDFaultResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testFindByIsITVSafe() {
        this.webTestClient
                .get()
                .uri(OBDFaultResource.OBDFAULTS + OBDFaultResource.ISNOTITVSAFE)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK);
    }
}
