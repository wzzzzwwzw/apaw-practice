package es.upm.miw.apaw_practice.adapters.rest.ticket_bus;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.PassengerAccessModification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
@RestTestConfig
public class PassengerResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateAccessPassenger() {
        PassengerAccessModification passengerAccessModification = new PassengerAccessModification(false, true);
        this.webTestClient
                .patch()
                .uri(PassengerResource.PASSENGERS + PassengerResource.ACCESSIBILITY)
                .body(BodyInserters.fromValue(passengerAccessModification))
                .exchange()
                .expectStatus().isOk();
    }
}
