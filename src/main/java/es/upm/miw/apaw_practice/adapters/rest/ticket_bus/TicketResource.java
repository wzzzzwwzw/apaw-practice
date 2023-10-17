package es.upm.miw.apaw_practice.adapters.rest.ticket_bus;

import es.upm.miw.apaw_practice.domain.services.ticket_bus.TicketBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Component("ticketResourceTicketBus")
@RestController
@RequestMapping(TicketResource.TICKETS)
public class TicketResource {


    static final String TICKETS = "/ticket_bus/tickets";
    static final String ARRIVE_DATE = "/{arrive}";


    private final TicketBusService ticketBusService;

    @Autowired
    public TicketResource(TicketBusService ticketBusService) {
        this.ticketBusService = ticketBusService;
    }

    @DeleteMapping(TicketResource.ARRIVE_DATE)
    public void deleteArriveDate(@PathVariable String arrive) {
        this.ticketBusService.deleteArriveDate(arrive);
    }
}
