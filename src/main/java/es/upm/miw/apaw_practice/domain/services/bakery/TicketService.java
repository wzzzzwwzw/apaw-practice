package es.upm.miw.apaw_practice.domain.services.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.Ticket;
import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.TicketPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TicketService {

    private final TicketPersistence ticketPersistence;

    @Autowired
    public TicketService(TicketPersistence ticketPersistence) {
        this.ticketPersistence = ticketPersistence;
    }

    public Ticket create(Ticket ticket) {
        return this.ticketPersistence.create(ticket);
    }

    public BigDecimal findTotalPriceSumForShelfName(String name) {
        return this.ticketPersistence.findTotalPriceSumForShelfName(name);
    }
}