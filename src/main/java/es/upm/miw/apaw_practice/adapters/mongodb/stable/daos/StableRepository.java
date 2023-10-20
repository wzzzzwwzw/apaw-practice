package es.upm.miw.apaw_practice.adapters.mongodb.stable.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.StableEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StableRepository extends MongoRepository<StableEntity, String> {
    Optional<StableEntity> findByName(String name);
}
