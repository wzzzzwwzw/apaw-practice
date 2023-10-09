package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.FurnitureStoreEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FurnitureStoreRepository extends MongoRepository<FurnitureStoreEntity, String>{
    Optional<FurnitureStoreEntity> findByName(String name);
}
