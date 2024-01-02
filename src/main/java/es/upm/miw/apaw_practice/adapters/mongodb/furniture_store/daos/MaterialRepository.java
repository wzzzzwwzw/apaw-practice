package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.MaterialEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MaterialRepository extends MongoRepository<MaterialEntity, String> {
    Optional<MaterialEntity> findByName(String name);
    int deleteByName(String name);
}
