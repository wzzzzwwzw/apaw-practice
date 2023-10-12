package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.MuseumSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class RoomPersistenceMongodbIT {

    @Autowired
    private RoomPersistenceMongodb roomPersistenceMongodb;
    @Autowired
    private MuseumSeederService museumSeederService;

    @BeforeEach
    void resetDataBase() {
        this.museumSeederService.deleteAll();
        this.museumSeederService.seedDatabase();
    }

    @Test
    void testReadFound() {
        Room room = new Room("Sala 012", 1, 9.75);
        Room foundRoom = this.roomPersistenceMongodb.findByDescription(room.getDescription());
        assertEquals(room.getDescription(), foundRoom.getDescription());
        assertEquals(room.getFloor(), foundRoom.getFloor());
        assertEquals(room.getPopularity(), foundRoom.getPopularity());
    }

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.roomPersistenceMongodb.findByDescription("Sala no existente"));
    }

    @Test
    void readAndUpdate() {
        Room foundRoom = this.roomPersistenceMongodb.findByDescription("Sala 012");

        foundRoom.setFloor(3);
        foundRoom.setPopularity(10.0);
        Room updatedRoom = this.roomPersistenceMongodb.update(foundRoom);

        assertEquals("Sala 012", updatedRoom.getDescription());
        assertEquals(3, updatedRoom.getFloor());
        assertEquals(10.0, updatedRoom.getPopularity());
    }

    @Test
    void readAndBadUpdate() {
        Room foundRoom = this.roomPersistenceMongodb.findByDescription("Sala 012");

        foundRoom.setDescription("Sala con distinto identificador");

        assertThrows(NotFoundException.class, () -> this.roomPersistenceMongodb.update(foundRoom));
    }
}
