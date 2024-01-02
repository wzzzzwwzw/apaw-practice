package es.upm.miw.apaw_practice.domain.services.film;

import es.upm.miw.apaw_practice.domain.persistence_ports.film.GenrePersistence;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    private final GenrePersistence genrePersistence;

    public GenreService(GenrePersistence genrePersistence) {
        this.genrePersistence = genrePersistence;
    }

    public void delete(String name) {
        this.genrePersistence.delete(name);
    }
}
