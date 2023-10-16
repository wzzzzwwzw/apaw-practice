package es.upm.miw.apaw_practice.adapters.mongodb.film.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.film.FilmSeederService;
import es.upm.miw.apaw_practice.domain.models.film.Film;
import es.upm.miw.apaw_practice.domain.models.film.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class FilmPersistenceMongodbIT {

    @Autowired
    private FilmPersistenceMongodb filmPersistenceMongodb;

    @Autowired
    private FilmSeederService filmSeederService;

    @Test
    void testReadByTitle() {
        Optional<Film> film = this.filmPersistenceMongodb.readByTitle("Face/Off")
                .findFirst();
        assertTrue(film.isPresent());
        assertNotNull(film.get().getFilmId());
        assertNotNull(film.get().getReleaseDate());
    }

    @Test
    void testUpdate() {
        Optional<Film> optionalFilm = this.filmPersistenceMongodb.readByTitle("Gladiator")
                .findFirst();
        assertTrue(optionalFilm.isPresent());
        List<Review> reviews = Arrays.asList(new Review(6, "New comment 1", false));
        Film film = optionalFilm.get();
        film.setReviews(reviews);
        this.filmPersistenceMongodb.update(film);
        Optional<Film> newFilm = this.filmPersistenceMongodb.readByTitle("Gladiator")
                .findFirst();
        assertTrue(newFilm.isPresent());
        assertEquals(film.getReleaseDate(), newFilm.get().getReleaseDate());
        assertEquals(1, newFilm.get().getReviews().size());
        assertEquals(6, newFilm.get().getReviews().get(0).getRating());

        filmSeederService.deleteAll();
        filmSeederService.seedDatabase();
    }

    @Test
    void testFindAverageRatingByDirectorDni() {
        Stream<Film> filmStream = this.filmPersistenceMongodb.findFilmsByDirectorDni("05645800X");
        assertNotNull(filmStream);
        assertEquals(1, filmStream.count());
    }

    @Test
    void testNotFindAverageRatingByDirectorDni() {
        Stream<Film> filmStream = this.filmPersistenceMongodb.findFilmsByDirectorDni("00X");
        assertNotNull(filmStream);
        assertEquals(0, filmStream.count());
    }
}
