package es.upm.miw.apaw_practice.adapters.rest.ticket_bus;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.Trip;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
@RestTestConfig
public class TripResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadByPath() {
        this.webTestClient
                .get()
                .uri(TripResource.TRIPS + TripResource.PATH, "Madrid-Toledo")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Trip.class);

    }
}
