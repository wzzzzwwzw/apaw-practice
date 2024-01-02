package es.upm.miw.apaw_practice.adapters.mongodb.film.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.DirectorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DirectorRepository extends MongoRepository<DirectorEntity, String> {
    Optional<DirectorEntity> findByDni(String dni);
}
