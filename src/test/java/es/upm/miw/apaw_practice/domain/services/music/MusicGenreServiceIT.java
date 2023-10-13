package es.upm.miw.apaw_practice.domain.services.music;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.music.MusicSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.music.MusicGenre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class MusicGenreServiceIT {

    @Autowired
    private MusicGenreService musicGenreService;

    @Autowired
    private MusicSeederService musicSeederService;

    @AfterEach
    void resetDB() {
        this.musicSeederService.deleteAll();
        this.musicSeederService.seedDatabase();
    }

    @Test
    void testCreateMusicGenre() {
        MusicGenre musicGenre = this.musicGenreService.create(new MusicGenre("jazz", "jazz music", 6, "EEUU"));
        assertNotNull(musicGenre);
        assertEquals("jazz", musicGenre.getType());
        assertEquals("jazz music", musicGenre.getDescription());
        assertEquals(6, musicGenre.getPopularity());
        assertEquals("EEUU", musicGenre.getCountryOrigin());
    }

    @Test
void testCreateAlreadyExistsMusicGenre() {
        MusicGenre musicGenre = new MusicGenre("rock", "rock music", 8, "EEUU");
        assertThrows(ConflictException.class, () -> this.musicGenreService.create(musicGenre));
    }
}
