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
    public Stream<Film> readByTitle(String title) {
        if (this.filmRepository.findByTitle(title).isEmpty())
            throw new NotFoundException("Film title : " + title);
        return this.filmRepository.findByTitle(title).stream()
                .map(FilmEntity::toFilm);
    }
}
