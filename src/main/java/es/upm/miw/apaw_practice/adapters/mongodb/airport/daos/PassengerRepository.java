package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.FlightEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PassengerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PassengerRepository extends MongoRepository<PassengerEntity, String> {
    Optional<FlightEntity> findByName(String name);
}
