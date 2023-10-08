package es.upm.miw.apaw_practice.adapters.mongodb.film.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.GenreEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GenreRepository extends MongoRepository<GenreEntity, String> {
    Optional<GenreEntity> findByName(String name);
}
