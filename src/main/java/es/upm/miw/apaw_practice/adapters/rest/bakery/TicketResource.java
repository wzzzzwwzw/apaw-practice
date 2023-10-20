package es.upm.miw.apaw_practice.adapters.rest.bakery;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.bakery.Ticket;
import es.upm.miw.apaw_practice.domain.services.bakery.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(TicketResource.TICKETS)
public class TicketResource {
    static final String TICKETS = "/bakery/tickets";
    static final String SEARCH = "/search";

    private final TicketService ticketService;

    @Autowired
    public TicketResource(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return this.ticketService.create(ticket);
    }

    @GetMapping(SEARCH)
    public BigDecimal findTotalPriceSumForShelfName(@RequestParam String q) {
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.ticketService.findTotalPriceSumForShelfName(name);
    }
}