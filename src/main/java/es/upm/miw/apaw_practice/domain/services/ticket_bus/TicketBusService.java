package es.upm.miw.apaw_practice.domain.services.ticket_bus;

import es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus.TicketPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class
TicketBusService {
    private final TicketPersistence ticketPersistence;

    @Autowired
    private TicketBusService(TicketPersistence ticketPersistence) {
        this.ticketPersistence = ticketPersistence;

    }

    public void deleteArriveDate(String arrive) {
        this.ticketPersistence.deleteArriveDate(arrive);
    }
}
