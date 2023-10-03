package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.CategoryRestaurantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRestaurantRepository extends MongoRepository<CategoryRestaurantEntity, String> {
}
