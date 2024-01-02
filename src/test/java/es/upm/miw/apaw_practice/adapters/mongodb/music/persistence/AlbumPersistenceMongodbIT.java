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
    void testFindAlbumsByRecordLabel() {
        assertEquals(1, this.albumPersistenceMongodb.findAlbumsByRecordLabel("La Industria Inc").count());
    }

    @Test
    void testGetDifferentDenominationsByFullname() {
        List<String> denominations = this.albumPersistenceMongodb.
                getDifferentDenominationsByFullname("J Balvin");
        assertEquals(2, denominations.size());
        assertTrue(denominations.contains("Colores"));
        assertTrue(denominations.contains("Fearless"));
    }
}
