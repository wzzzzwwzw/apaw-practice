package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
