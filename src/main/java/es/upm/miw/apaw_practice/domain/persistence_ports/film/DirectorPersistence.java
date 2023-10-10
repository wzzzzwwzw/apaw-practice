package es.upm.miw.apaw_practice.domain.persistence_ports.film;

import es.upm.miw.apaw_practice.domain.models.film.Director;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorPersistence {

    Director create(Director director);

    boolean existsDirectorDni(String dni);

    Director read(String dni);
}
