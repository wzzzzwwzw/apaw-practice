package es.upm.miw.apaw_practice.adapters.mongodb.school.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.SubjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubjectRepository extends MongoRepository<SubjectEntity, String> {
    Optional<SubjectEntity> findByTitle(String title);
}