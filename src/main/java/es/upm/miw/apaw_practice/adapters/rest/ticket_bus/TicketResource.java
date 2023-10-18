package es.upm.miw.apaw_practice.adapters.rest.ticket_bus;

import es.upm.miw.apaw_practice.domain.models.ticket_bus.Ticket;
import es.upm.miw.apaw_practice.domain.services.ticket_bus.TicketBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Component("ticketResourceTicketBus")
@RestController
@RequestMapping(TicketResource.TICKETS)
public class TicketResource {


    static final String TICKETS = "/ticket_bus/tickets";
    static final String ARRIVE_DATE = "/{arrive}";
    static final String PRICE_HIGHER = "/ticket_bus/tickets/price_higher/{price}";

    private final TicketBusService ticketBusService;

    @Autowired
    public TicketResource(TicketBusService ticketBusService) {
        this.ticketBusService = ticketBusService;
    }

    @DeleteMapping(TicketResource.ARRIVE_DATE)
    public void deleteArriveDate(@PathVariable String arrive) {
        this.ticketBusService.deleteArriveDate(arrive);
    }

    @GetMapping(TicketResource.PRICE_HIGHER)
    public List<Ticket> getTicketsWithPriceHigherThan(@PathVariable BigDecimal price) {
        return this.ticketBusService.findTicketsByPriceGreaterThan(price);
    }
}
