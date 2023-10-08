package es.upm.miw.apaw_practice.adapters.mongodb.film.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.FilmEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FilmRepository extends MongoRepository<FilmEntity, String> {
    List<FilmEntity> findByTitle(String title);
}
