package es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.ShelfEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ShelfRepository extends MongoRepository<ShelfEntity, String> {
    Optional<ShelfEntity> findByName(String name);
    
}