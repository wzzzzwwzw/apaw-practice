package es.upm.miw.apaw_practice.adapters.mongodb.film.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.film.daos.FilmRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.FilmEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.film.Film;
import es.upm.miw.apaw_practice.domain.persistence_ports.film.FilmPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("filmPersistence")
public class FilmPersistenceMongodb implements FilmPersistence {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmPersistenceMongodb(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Film readById(String id) {
        return this.filmRepository.findAll().stream()
                .filter(filmEntity -> filmEntity.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException((" Film id: " + id)))
                .toFilm();
    }

    @Override
    public Stream<Film> readAll() {
        return this.filmRepository.findAll().stream()
                .map(FilmEntity::toFilm);
    }
}
