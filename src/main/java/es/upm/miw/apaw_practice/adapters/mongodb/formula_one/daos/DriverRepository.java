package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.DriverEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DriverRepository extends MongoRepository<DriverEntity, String> {
    Optional<DriverEntity> findByNumber(Integer number);
}
