package es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus;

import es.upm.miw.apaw_practice.domain.models.ticket_bus.Trip;
import org.springframework.stereotype.Repository;

@Repository
public interface TripPersistence {
    Trip readByPath(String path);
}
