package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.AirLineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AirLineRepository extends MongoRepository<AirLineEntity, String> {
    Optional<AirLineEntity> findByName(String name);
}
