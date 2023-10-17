package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class AlbumPersistenceMongodbIT {

    @Autowired
    private AlbumPersistenceMongodb albumPersistenceMongodb;

    @Test
    void testReadSongsByAlbumDenomination() {
        assertEquals(2, this.albumPersistenceMongodb.readSongsByAlbumDenomination("Colores").count());
    }

    @Test
    void testReadSongsByAlbumDenominationNotFound() {
        assertThrows(NotFoundException.class, () -> this.albumPersistenceMongodb.readSongsByAlbumDenomination("album2"));
    }

    @Test
    void testGetPhoneNumberByTypeAndRecordLabel() {
        List<Integer> phoneNumbers = this.albumPersistenceMongodb.
                getPhoneNumberByTypeAndRecordLabel("reggaeton", "La Industria Inc").
                toList();
        assertEquals(3, phoneNumbers.size());
        assertTrue(phoneNumbers.contains(123456789));
        assertTrue(phoneNumbers.contains(222222222));
        assertTrue(phoneNumbers.contains(333333333));
    }
}
