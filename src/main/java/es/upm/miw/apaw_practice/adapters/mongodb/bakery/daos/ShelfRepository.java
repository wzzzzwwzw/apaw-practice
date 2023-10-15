package es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.ShelfEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShelfRepository extends MongoRepository<ShelfEntity, String> {
    
}