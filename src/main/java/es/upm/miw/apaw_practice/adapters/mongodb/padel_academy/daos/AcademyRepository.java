package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities.AcademyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AcademyRepository extends MongoRepository<AcademyEntity, String> {
}
