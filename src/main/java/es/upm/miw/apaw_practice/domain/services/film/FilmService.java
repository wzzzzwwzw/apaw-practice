package es.upm.miw.apaw_practice.domain.services.film;

import es.upm.miw.apaw_practice.domain.models.film.Film;
import es.upm.miw.apaw_practice.domain.persistence_ports.film.FilmPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class FilmService {

    private final FilmPersistence filmPersistence;

    @Autowired
    public FilmService(FilmPersistence filmPersistence) {
        this.filmPersistence = filmPersistence;
    }

    public Stream<Film> read(String title) {
        return this.filmPersistence.readByTitle(title);
    }
}
