package es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelActivityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class HotelActivityRepositoryIT {
    @Autowired
    private HotelActivityRepository ActivityRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.ActivityRepository.findByName("Volleyball").isPresent());
        HotelActivityEntity firstClient = this.ActivityRepository.findByName("Volleyball").get();
        assertEquals(firstClient.getName(), "Volleyball");
        assertEquals(firstClient.getSchedule(), "X 17:00, V 17:00");
        assertEquals(firstClient.getInstructor(), "Carlos");
        assertEquals(firstClient.getMaxParticipants(), 20);
    }
}
