package es.upm.miw.apaw_practice.adapters.mongodb.bakery.persistence;

import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.TicketPersistence;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos.TicketRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.TicketEntity;
import es.upm.miw.apaw_practice.domain.models.bakery.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository("ticketPersistence")
public class TicketPersistenceMongodb implements TicketPersistence {
    
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketPersistenceMongodb(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket create(Ticket ticket) {
        return this.ticketRepository
                .save(new TicketEntity(ticket))
                .toTicket();
    }

    @Override
    public BigDecimal findTotalPriceSumForShelfName(String name) {
        return this.ticketRepository.findAll().stream()
            .filter(ticket -> ticket.getProducts().stream()
                    .anyMatch(product -> name.equals(product.getShelf().getName())))
            .map(TicketEntity::getTotalPrice) 
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
