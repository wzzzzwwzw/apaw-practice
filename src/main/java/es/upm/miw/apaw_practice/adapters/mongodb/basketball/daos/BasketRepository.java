package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.BasketEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BasketRepository extends MongoRepository<BasketEntity, String> {
}
