package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.EngineManufacturerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EngineManufacturerRepository extends MongoRepository<EngineManufacturerEntity, String> {
    Optional<EngineManufacturerEntity> findByManufacturerName(String manufacturerName);
}
