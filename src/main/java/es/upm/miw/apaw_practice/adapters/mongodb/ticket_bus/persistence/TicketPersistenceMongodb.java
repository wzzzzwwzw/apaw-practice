package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.TicketRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus.TicketPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ticketPersistenceTicketBus")
public class TicketPersistenceMongodb implements TicketPersistence {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketPersistenceMongodb(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;

    }

    @Override
    public void deleteArriveDate(String arrive) {
        this.ticketRepository.deleteByArrive(arrive);
    }


}
