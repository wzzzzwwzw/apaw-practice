package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.CoffeeClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CoffeeClientRepository extends MongoRepository<CoffeeClientEntity, String> {
    Optional<CoffeeClientEntity> findByName(String name);
    int deleteByName(String name);

}

