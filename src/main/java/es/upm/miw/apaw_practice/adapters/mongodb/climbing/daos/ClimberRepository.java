package es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.ClimberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClimberRepository extends MongoRepository<ClimberEntity, String> {
}