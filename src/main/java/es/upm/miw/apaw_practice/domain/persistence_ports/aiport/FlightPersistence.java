package es.upm.miw.apaw_practice.domain.persistence_ports.aiport;

import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;


@Repository
public interface FlightPersistence {
    Flight create(Flight flight);
    boolean existFlight(Integer numberOfFlight);
    Stream<String> findAirlineNameByPassengerAgeGreaterThan(Integer age);
    Double findAverageAgeByModel(String model);
}
