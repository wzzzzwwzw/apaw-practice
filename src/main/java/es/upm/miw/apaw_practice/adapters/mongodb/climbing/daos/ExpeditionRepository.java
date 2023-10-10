package es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.ExpeditionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ExpeditionRepository extends MongoRepository<ExpeditionEntity, String> {
}