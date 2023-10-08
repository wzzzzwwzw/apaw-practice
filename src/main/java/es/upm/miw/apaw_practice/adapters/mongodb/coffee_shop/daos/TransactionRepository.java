package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.TransactionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {
    Optional<TransactionEntity> findByOrder(String order);
}