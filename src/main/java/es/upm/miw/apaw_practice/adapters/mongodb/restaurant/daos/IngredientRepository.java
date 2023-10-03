package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.IngredientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IngredientRepository extends MongoRepository<IngredientRepository, String> {
    Optional<IngredientEntity> findByName(String name);
}
