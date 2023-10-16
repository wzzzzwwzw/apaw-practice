package es.upm.miw.apaw_practice.adapters.rest.bakery;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.BakerySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.bakery.Product;
import es.upm.miw.apaw_practice.domain.models.bakery.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestTestConfig
class TicketResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private BakerySeederService bakerySeederService;

    @BeforeEach
    void resetDb() {
        this.bakerySeederService.deleteAll();
        this.bakerySeederService.seedDatabase();
    }

    @Test
    void testCreate() {
        Ticket ticket = new Ticket(LocalDateTime.of(2024, 1, 1, 10, 50, 50), new BigDecimal("2.00"), 1, List.of(new Product()));
        this.webTestClient
                .post()
                .uri(TicketResource.TICKETS)
                .body(BodyInserters.fromValue(ticket))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Ticket.class)
                .value(Assertions::assertNotNull);
    }
}