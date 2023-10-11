package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.FlightEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FlightRepository extends MongoRepository<FlightEntity, String> {
    Optional<FlightEntity> findByNumberOfFlight(Integer numberOfFlight);
}
