package es.upm.miw.apaw_practice.domain.services.hotel;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.services.hospital.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class HotelServiceIT {
    @Autowired
    private HotelService hotelService;

    @Test
    void testReadService(){
        Hotel hotel = hotelService.read("Diamond");
        assertNotNull(hotel);
        assertEquals("Diamond", hotel.getName());
        assertEquals(5, hotel.getStars());
        assertEquals(700, hotel.getRooms());
        assertNotNull(hotel.getBookings());
        assertNotNull(hotel.getActivities());
    }
}
