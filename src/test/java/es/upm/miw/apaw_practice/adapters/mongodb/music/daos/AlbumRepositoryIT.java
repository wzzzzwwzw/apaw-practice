package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.music.MusicSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.AlbumEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class AlbumRepositoryIT {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private MusicSeederService musicSeederService;

    @AfterEach
    void resetDB() {
        this.musicSeederService.deleteAll();
        this.musicSeederService.seedDatabase();
    }

    @Test
    void testFindByDenomination() {
        assertTrue(this.albumRepository.findByDenomination("Colores").isPresent());
        AlbumEntity album = this.albumRepository.findByDenomination("Colores").get();
        assertEquals("Colores", album.getDenomination());
        assertEquals(LocalDateTime.of(2010, 5, 17, 12, 16, 17), album.getReleaseDate());
        assertEquals("La Industria Inc", album.getRecordLabel());
        assertEquals(2, album.getSongsList().size());
        assertAlbumSongs(album, "Una Locura");
        assertAlbumSongs(album, "El Vals del Obrero");
    }

    private void assertAlbumSongs(AlbumEntity album, String songTitle) {
        assertTrue(album.getSongsList()
                .stream()
                .anyMatch(song ->
                        song.getTitle().equals(songTitle)
                )
        );
    }
    @Test
    void testDeleteByDenomination() {
        this.albumRepository.deleteByDenomination("Fearless");
        assertFalse(this.albumRepository.findByDenomination("Fearless").isPresent());
    }
}
