package es.upm.miw.apaw_practice.adapters.mongodb.swimming.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.LessonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LessonRepository extends MongoRepository<LessonEntity, String> {

    Optional<LessonEntity> findByStyle(String style);
}
