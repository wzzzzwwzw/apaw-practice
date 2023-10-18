package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.TicketRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TicketEntity;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.Ticket;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus.TicketPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public List<Ticket> findTicketsByPriceGreaterThan(BigDecimal price) {
        List<TicketEntity> ticketEntities = ticketRepository.findTicketsByPriceGreaterThan(price);
        return ticketEntities.stream()
                .map(this::toTicket)
                .collect(Collectors.toList());
    }

    private Ticket toTicket(TicketEntity ticketEntity) {

        return new Ticket(
                ticketEntity.getDeparture(),
                ticketEntity.getArrive(),
                ticketEntity.getPrice()
        );
    }

}
