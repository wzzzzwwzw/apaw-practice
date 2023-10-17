package es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelActivityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class HotelActivityRepositoryIT {
    @Autowired
    private HotelActivityRepository ActivityRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.ActivityRepository.findByInstructor("Adam").isPresent());
        HotelActivityEntity firstClient = this.ActivityRepository.findByInstructor("Adam").get();
        assertEquals(firstClient.getName(),"AquaGym");
        assertEquals(firstClient.getSchedule(),"L 16:00, X 16:00, V 16:00");
        assertEquals(firstClient.getInstructor(),"Adam");
        assertEquals(firstClient.getMaxParticipants(),20);
    }
}
