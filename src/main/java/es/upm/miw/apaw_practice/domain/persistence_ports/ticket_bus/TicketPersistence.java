package es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus;

import es.upm.miw.apaw_practice.domain.models.ticket_bus.Ticket;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TicketPersistence {
    void deleteArriveDate(String arrive);

    List<Ticket> findTicketsByPriceGreaterThan(BigDecimal price);
}
