package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.DrivingStyleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DrivingStyleRepository extends MongoRepository<DrivingStyleEntity, String> {
}
