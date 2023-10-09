package es.upm.miw.apaw_practice.domain.persistence_ports.film;

import es.upm.miw.apaw_practice.domain.models.film.Film;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface FilmPersistence {

    Film readById(String id);

    Stream<Film> readAll();
}
