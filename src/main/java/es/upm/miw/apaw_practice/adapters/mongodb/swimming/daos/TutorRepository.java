package es.upm.miw.apaw_practice.adapters.mongodb.swimming.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.TutorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TutorRepository extends MongoRepository<TutorEntity, String> {

    Optional<TutorEntity> findByAppellation(String appellation);
}
