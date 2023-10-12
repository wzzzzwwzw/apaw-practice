package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import es.upm.miw.apaw_practice.domain.models.museum.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ArtWorkPersistenceMongodbIT {

    @Autowired
    private ArtWorkPersistenceMongodb artWorkPersistence;

    @Test
    void testReadFound() {
        ArtWork artWork = new ArtWork("P001174", "Las Meninas", 1656, true, new Room("Sala 012", 1, 9.75));
        ArtWork foundArtWork = this.artWorkPersistence.findByInventoryNumber("P001174");
        assertEquals(artWork.getInventoryNumber(), foundArtWork.getInventoryNumber());
    }

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.artWorkPersistence.findByInventoryNumber("P000001"));
    }

    @Test
    void testInventoryNumberExists() {
        assertTrue(this.artWorkPersistence.existsInventoryNumber("P000796"));
    }

    @Test
    void testInventoryNumberNotExists() {
        assertFalse(this.artWorkPersistence.existsInventoryNumber("P000001"));
    }

    @Test
    void testCreateAndRead() {
        Room room = new Room("Sala 009", 1, 7.25);
        ArtWork artWork = new ArtWork("P001248", "Hércules desvía el curso del río Alfeo", 1634, true, room);

        this.artWorkPersistence.create(artWork);

        ArtWork artWorkDB = this.artWorkPersistence.findByInventoryNumber(artWork.getInventoryNumber());

        assertEquals(artWork.getInventoryNumber(), artWorkDB.getInventoryNumber());
        assertEquals(artWork.getTitle(), artWorkDB.getTitle());
        assertEquals(artWork.getApproximateYear(), artWorkDB.getApproximateYear());
        assertEquals(artWork.isExhibited(), artWorkDB.isExhibited());
        assertEquals(artWork.getRoom().getDescription(), artWorkDB.getRoom().getDescription());
        assertEquals(artWork.getRoom().getFloor(), artWorkDB.getRoom().getFloor());
        assertEquals(artWork.getRoom().getPopularity(), artWorkDB.getRoom().getPopularity());
    }
}
