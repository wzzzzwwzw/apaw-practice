package es.upm.miw.apaw_practice.adapters.rest.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.Ticket;
import es.upm.miw.apaw_practice.domain.services.bakery.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TicketResource.TICKETS)
public class TicketResource {
    static final String TICKETS = "/bakery/tickets";

    private final TicketService ticketService;

    @Autowired
    public TicketResource(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return this.ticketService.create(ticket);
    }
}