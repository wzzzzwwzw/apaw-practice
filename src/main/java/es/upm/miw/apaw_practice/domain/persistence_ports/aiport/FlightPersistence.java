package es.upm.miw.apaw_practice.domain.persistence_ports.aiport;

import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FlightPersistence {
    Flight create(Flight flight);
    boolean existFlight(Integer numberOfFlight);
}
