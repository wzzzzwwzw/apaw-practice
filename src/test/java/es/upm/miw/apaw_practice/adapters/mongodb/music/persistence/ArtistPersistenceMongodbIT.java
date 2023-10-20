package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.music.MusicSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.music.Artist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class ArtistPersistenceMongodbIT {

    @Autowired
    private ArtistPersistenceMongodb artistPersistenceMongodb;

    @Autowired
    private MusicSeederService musicSeederService;

    @AfterEach
    void resetDB() {
        this.musicSeederService.deleteAll();
        this.musicSeederService.seedDatabase();
    }

    @Test
    void testReadByDni() {
        Artist artist = this.artistPersistenceMongodb.readByDni("22222222D");
        assertEquals("22222222D", artist.getDni());
        assertEquals("Ozuna", artist.getFullName());
        assertEquals(222222222, artist.getPhoneNumber());
        assertEquals(LocalDate.of(1989, 12, 30), artist.getBirthDate());
    }

    @Test
    void testUpdatePhoneNumber() {
        Artist artist = this.artistPersistenceMongodb.readByDni("22222222D");
        artist.setPhoneNumber(666666666);
        this.artistPersistenceMongodb.updatePhoneNumber(artist);
        artist = this.artistPersistenceMongodb.readByDni("22222222D");
        assertEquals(666666666, artist.getPhoneNumber());
    }

    @Test
    void testUpdatePhoneNumberNotFound() {
        Artist artist = new Artist("11111111A", "Bad Bunny", 111111111, LocalDate.of(1994, 3, 10));
        assertThrows(NotFoundException.class, () -> this.artistPersistenceMongodb.updatePhoneNumber(artist));
    }
}
