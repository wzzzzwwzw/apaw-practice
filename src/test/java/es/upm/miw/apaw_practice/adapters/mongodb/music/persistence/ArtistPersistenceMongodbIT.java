package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.music.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class ArtistPersistenceMongodbIT {

    @Autowired
    private ArtistPersistenceMongodb artistPersistenceMongodb;

    @Test
    void testReadByDni() {
        Artist artist = this.artistPersistenceMongodb.readByDni("22222222D");
        assertEquals("22222222D", artist.getDni());
        assertEquals("Ozuna", artist.getFullName());
        assertEquals(222222222, artist.getPhoneNumber());
        assertEquals(LocalDate.of(1989, 12, 30), artist.getBirthDate());
    }
}
