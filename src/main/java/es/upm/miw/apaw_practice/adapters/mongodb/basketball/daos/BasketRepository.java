package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.BasketEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface BasketRepository extends MongoRepository<BasketEntity, String> {
    Optional<BasketEntity> findByIdentifier(String identifier);

}
