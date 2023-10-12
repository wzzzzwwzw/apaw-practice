package es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.AreaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AreaRepository extends MongoRepository<AreaEntity, String> {
    Optional<AreaEntity> findByName(String name);
}