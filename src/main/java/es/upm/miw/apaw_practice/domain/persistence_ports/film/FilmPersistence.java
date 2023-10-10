package es.upm.miw.apaw_practice.domain.persistence_ports.film;

import es.upm.miw.apaw_practice.domain.models.film.Film;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface FilmPersistence {

    Stream<Film> readByTitle(String title);

    Film update(Film film);

}
