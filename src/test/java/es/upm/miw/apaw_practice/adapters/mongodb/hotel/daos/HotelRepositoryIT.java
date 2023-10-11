package es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.dao.HotelRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelEntity;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class HotelRepositoryIT {
    @Autowired
    private HotelRepository hotelRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.hotelRepository.findByName("Diamond").isPresent());
        HotelEntity hotelDiamond = this.hotelRepository.findByName("Diamond").get();
        assertEquals("Diamond", hotelDiamond.getName());
        assertEquals(5, hotelDiamond.getStars());
        assertEquals(700, hotelDiamond.getRooms());
        List<HotelBooking> bookings = hotelDiamond.getBookings();
        for (HotelBooking booking : bookings) {
            assertNotNull(booking);
        }
        List<HotelActivity> activities = hotelDiamond.getActivities();
        for (HotelActivity activity : activities) {
            assertNotNull(activity);
        }
    }
}
