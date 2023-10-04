package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.RestaurantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RestaurantRepository extends MongoRepository<RestaurantEntity, String> {
    Optional<RestaurantEntity> findByName(String name);
}
