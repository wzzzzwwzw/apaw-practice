package es.upm.miw.apaw_practice.adapters.mongodb.film.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.film.FilmSeederService;
import es.upm.miw.apaw_practice.domain.models.film.Film;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class FilmPersistenceMongodbIT {

    @Autowired
    private FilmPersistenceMongodb filmPersistenceMongodb;

    @Autowired
    private FilmSeederService filmSeederService;

    @Test
    void testReadById() {
        Optional<Film> film = this.filmPersistenceMongodb.readAll()
                .filter(film1 -> "Face/Off".equals(film1.getTitle()))
                .findFirst();
        assertTrue(film.isPresent());
        assertNotNull(film.get().getFilmId());
        assertNotNull(film.get().getReleaseDate());
    }
}
