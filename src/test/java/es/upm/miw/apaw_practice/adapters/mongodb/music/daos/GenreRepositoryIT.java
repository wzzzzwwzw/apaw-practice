package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.GenreEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class GenreRepositoryIT {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    void testFindByType() {
        assertTrue(this.genreRepository.findByType("reggaeton").isPresent());
        GenreEntity genre = this.genreRepository.findByType("reggaeton").get();
        assertEquals("reggaeton", genre.getType());
        assertEquals("reggaeton music", genre.getDescription());
        assertEquals(10, genre.getPopularity());
        assertEquals("Puerto Rico", genre.getCountryOrigin());
    }
}
