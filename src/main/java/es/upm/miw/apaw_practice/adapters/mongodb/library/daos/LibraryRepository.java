package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LibraryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LibraryRepository extends MongoRepository<LibraryEntity, String> {
    Optional<LibraryEntity> findByName(String name);
}
