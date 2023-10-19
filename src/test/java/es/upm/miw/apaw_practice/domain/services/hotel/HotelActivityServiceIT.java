package es.upm.miw.apaw_practice.domain.services.hotel;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class HotelActivityServiceIT {
    @Autowired
    private HotelActivityService activityService;

    @Test
    void testUpdateService(){
        HotelActivity activityUpdated = activityService.updateInstructor("AquaGym","Alex");
        assertNotNull(activityUpdated);
        assertEquals(activityUpdated.getName(), "AquaGym");
        assertEquals(activityUpdated.getSchedule(), "L 16:00, X 16:00, V 16:00");
        assertEquals(activityUpdated.getInstructor(), "Alex");
        assertEquals(activityUpdated.getMaxParticipants(), 20);
    }
}
