package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.TransportEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TransportRepository extends MongoRepository<TransportEntity, String> {
    Optional<TransportEntity> findByCode(String code);
}
