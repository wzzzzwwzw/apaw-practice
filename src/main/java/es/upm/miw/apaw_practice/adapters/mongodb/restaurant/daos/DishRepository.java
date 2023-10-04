package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.DishEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DishRepository extends MongoRepository<DishEntity, String> {
    Optional<DishEntity> findByTitle(String title);
}
