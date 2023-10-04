package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.RaceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RaceRepository extends MongoRepository<RaceEntity, String> {
    Optional<RaceEntity> findByCircuitName(String circuitName);
}
