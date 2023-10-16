package es.upm.miw.apaw_practice.domain.persistence_ports.aiport;

import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerPersistence {
    Passenger readByName(String name);
    Passenger update(Passenger passenger);
}
