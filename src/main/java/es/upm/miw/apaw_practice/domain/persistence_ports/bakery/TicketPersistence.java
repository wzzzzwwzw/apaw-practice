package es.upm.miw.apaw_practice.domain.persistence_ports.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.Ticket;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TicketPersistence {

    Ticket create(Ticket ticket);

    BigDecimal findTotalPriceSumForShelfName(String name);
}
