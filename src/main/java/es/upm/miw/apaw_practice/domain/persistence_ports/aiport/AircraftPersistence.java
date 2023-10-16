package es.upm.miw.apaw_practice.domain.persistence_ports.aiport;

import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftPersistence {
    void delete(String numberPlate);
}
