package es.upm.miw.apaw_practice.domain.persistence_ports.aiport;

import org.springframework.stereotype.Repository;

@Repository
public interface AircraftPersistence {
    void delete(String numberPlate);
}
