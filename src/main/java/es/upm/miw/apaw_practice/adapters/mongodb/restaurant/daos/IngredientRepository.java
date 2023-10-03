package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientRepository extends MongoRepository<IngredientRepository, String> {
}
