package es.upm.miw.apaw_practice.adapters.mongodb.school.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.ClassroomEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClassroomRepository extends MongoRepository<ClassroomEntity, String> {
    Optional<ClassroomEntity> findByLocation(String location);
}