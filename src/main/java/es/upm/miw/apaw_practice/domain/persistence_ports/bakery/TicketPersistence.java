package es.upm.miw.apaw_practice.domain.persistence_ports.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPersistence {

    Ticket create(Ticket ticket);
}
