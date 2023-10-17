package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.CoffeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CoffeeRepository extends MongoRepository<CoffeeEntity, String> {
    Optional<CoffeeEntity> findByCoffee(String coffee);
}

