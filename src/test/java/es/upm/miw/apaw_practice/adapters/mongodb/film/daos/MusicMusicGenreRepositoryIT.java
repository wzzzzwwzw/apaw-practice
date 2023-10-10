package es.upm.miw.apaw_practice.adapters.mongodb.film.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.GenreEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class MusicMusicGenreRepositoryIT {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    void testFindByName() {
        assertTrue(this.genreRepository.findByName("Action").isPresent());
        GenreEntity genre = this.genreRepository.findByName("Action").get();
        assertEquals("Associated with particular types of spectacle", genre.getDescription());
        assertEquals("Absolute", genre.getStyle());
    }
}
