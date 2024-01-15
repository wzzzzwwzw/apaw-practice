package es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistance.HotelActivityPersistenceMongodb;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class HotelActivityPersistenceMongodbIT {
    @Autowired
    private HotelActivityPersistenceMongodb hotelActivityPersistence;

    @Autowired
    private HotelSeederService hotelSeeder;

    @AfterEach
    public void resetDataBase() {
        this.hotelSeeder.deleteAll();
        this.hotelSeeder.seedDatabase();
    }

    @Test
    void testReadNotFound() {
        assertFalse(this.hotelActivityPersistence.existsActivity("-"));
    }

    @Test
    void testReadFound() {
        assertTrue(this.hotelActivityPersistence.existsActivity("Surf"));
    }

    @Test
    void testUpdateInstructor() {
        HotelActivity updatedActivity = this.hotelActivityPersistence.updateInstructor("Tennis", "Elena");
        assertNotNull(updatedActivity);
        assertEquals(updatedActivity.getName(), "Tennis");
        assertEquals(updatedActivity.getInstructor(), "Elena");
        assertEquals(updatedActivity.getMaxParticipants(), 12);
        assertEquals(updatedActivity.getSchedule(), "L 12:00, X 12:00");
    }

    @Test
    void testActivityNotFound() {
        assertThrows(NotFoundException.class, () -> this.hotelActivityPersistence.updateInstructor("Football", "David"));
    }
}
