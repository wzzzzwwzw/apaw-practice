package es.upm.miw.apaw_practice.adapters.rest.ticket_bus;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.Trip;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class TripResourceIT {
    @Autowired
    private WebTestClient webTestClient;

   // @Test
    void testReadByPath() {
        this.webTestClient
                .get()
                .uri(TripResource.TRIPS + TripResource.PATH, "Madrid-Toledo")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Trip.class);

    }

   // @Test
    void testGetSumOfTicketPricesByPath() {
        EntityExchangeResult<BigDecimal> result = this.webTestClient
                .get()
                .uri(TripResource.TRIPS + TripResource.PATH + "/total-price", "Madrid-Toledo")
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .returnResult();

        BigDecimal totalPrice = result.getResponseBody();
        assertNotNull(totalPrice);
        assertTrue(totalPrice.compareTo(BigDecimal.ZERO) >= 0);
    }
}
