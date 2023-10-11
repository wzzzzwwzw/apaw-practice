package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.AircraftEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AircraftRepository extends MongoRepository<AircraftEntity, String> {
}
