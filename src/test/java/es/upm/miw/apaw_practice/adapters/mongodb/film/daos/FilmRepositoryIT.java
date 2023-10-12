package es.upm.miw.apaw_practice.adapters.mongodb.film.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.FilmEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class FilmRepositoryIT {

    @Autowired
    private FilmRepository filmRepository;

    @Test
    void testFindByTitle() {
        assertFalse(this.filmRepository.findByTitle("Gladiator").isEmpty());
        List<FilmEntity> films = this.filmRepository.findByTitle("Gladiator");
        assertEquals("Synopsis 3", films.get(0).getSynopsis());
        assertEquals("75128762Z", films.get(0).getDirectorEntity().getDni());
        assertTrue(films.get(0).getReleaseDate() != null &&
                films.get(0).getReleaseDate().isBefore(LocalDate.now().plusDays(1)));
        assertTrue(
                films.get(0).getGenreEntities().stream()
                        .anyMatch(genre ->
                                genre.getName().equals("Romance")
                        )
        );
        assertTrue(
                films.get(0).getReviewEntities().stream()
                        .anyMatch(review ->
                                review.getRating().equals(4) &&
                                review.getComment().equals("Comment 5") &&
                                review.getRecommendation().equals(false))
        );
    }
}
