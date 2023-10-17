package es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus;

import es.upm.miw.apaw_practice.domain.models.ticket_bus.Bus;
import org.springframework.stereotype.Repository;

@Repository
public interface BusPersistence {
    void create(Bus bus);

    boolean existReferenceBus(String busReference);

}
