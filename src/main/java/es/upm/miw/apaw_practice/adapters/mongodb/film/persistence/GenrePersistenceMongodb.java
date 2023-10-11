package es.upm.miw.apaw_practice.adapters.mongodb.film.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.film.daos.GenreRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.film.GenrePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("genrePersistence")
public class GenrePersistenceMongodb implements GenrePersistence {

    private final GenreRepository genreRepository;

    @Autowired
    public GenrePersistenceMongodb(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void delete(String name) {
        this.genreRepository.deleteByName(name);
    }
}
