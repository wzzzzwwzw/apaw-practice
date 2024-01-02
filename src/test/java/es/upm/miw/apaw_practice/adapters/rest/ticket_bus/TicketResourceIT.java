package es.upm.miw.apaw_practice.adapters.rest.ticket_bus;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.TicketBusSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TicketEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testGetTicketsWithPriceHigherThan() {

        ticketBusSeederService.seedDatabase();

        List<TicketEntity> testTickets = List.of(
                new TicketEntity("E1", "17:00", "18:00", LocalDateTime.now(), new BigDecimal("14.00")),
                new TicketEntity("E1", "17:00", "18:00", LocalDateTime.now(), new BigDecimal("20.00"))

                );

        BigDecimal priceToSearch = new BigDecimal("15.00");
        int expectedCount = (int) testTickets.stream()
                .filter(ticketEntity -> ticketEntity.getPrice().compareTo(priceToSearch) > 0)
                .count();

        List<TicketEntity> result = this.webTestClient
                .get()
                .uri(TicketResource.TICKETS + TicketResource.PRICE_HIGHER, priceToSearch)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(TicketEntity.class)
                .returnResult()
                .getResponseBody();

        assert result != null;
        assertEquals(expectedCount, result.size());
    }
}
