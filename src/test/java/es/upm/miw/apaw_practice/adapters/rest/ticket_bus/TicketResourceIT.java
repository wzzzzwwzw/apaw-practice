package es.upm.miw.apaw_practice.adapters.rest.ticket_bus;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.TicketBusSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
@RestTestConfig
public class TicketResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private TicketBusSeederService ticketBusSeederService;

    @Test
    void testDeleteArriveDate() {

        this.webTestClient
                .delete()
                .uri(TicketResource.TICKETS + TicketResource.ARRIVE_DATE, "E1")
                .exchange()
                .expectStatus().isOk();
    }
}
