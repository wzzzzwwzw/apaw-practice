package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.MuseumSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import es.upm.miw.apaw_practice.domain.models.museum.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ArtWorkPersistenceMongodbIT {

    @Autowired
    private ArtWorkPersistenceMongodb artWorkPersistence;
    @Autowired
    private MuseumSeederService museumSeederService;

    @BeforeEach
    void resetDataBase() {
        this.museumSeederService.deleteAll();
        this.museumSeederService.seedDatabase();
    }

    @Test
    void testReadFound() {
        Room room = new Room().builder()
                .description("Sala 012")
                .floor(1)
                .popularity(9.75)
                .build();
        ArtWork artWork = new ArtWork().builder()
                .inventoryNumber("P001174")
                .title("Las Meninas")
                .approximateYear(1656)
                .exhibited(true)
                .room(room)
                .build();

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
        Room room = new Room().builder()
                .description("Sala 009")
                .floor(1)
                .popularity(7.25)
                .build();
        ArtWork artWork = new ArtWork().builder()
                .inventoryNumber("P001248")
                .title("Hércules desvía el curso del río Alfeo")
                .approximateYear(1634)
                .exhibited(true)
                .room(room)
                .build();

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
