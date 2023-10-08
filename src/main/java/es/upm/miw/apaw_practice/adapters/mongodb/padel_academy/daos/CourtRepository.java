package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities.CourtEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourtRepository extends MongoRepository<CourtEntity, Integer> {
}
