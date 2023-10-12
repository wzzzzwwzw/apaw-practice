package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.MusicGenreEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class MusicGenreRepositoryIT {

    @Autowired
    private MusicGenreRepository musicGenreRepository;

    @Test
    void testFindByType() {
        assertTrue(this.musicGenreRepository.findByType("reggaeton").isPresent());
        MusicGenreEntity musicGenre = this.musicGenreRepository.findByType("reggaeton").get();
        assertEquals("reggaeton", musicGenre.getType());
        assertEquals("reggaeton music", musicGenre.getDescription());
        assertEquals(10, musicGenre.getPopularity());
        assertEquals("Puerto Rico", musicGenre.getCountryOrigin());
    }
}
