package es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus;

import org.springframework.stereotype.Repository;

@Repository
public interface TicketPersistence {
    void deleteArriveDate(String arrive);
}
