package es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelBookingEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class HotelBookingRepositoryIT {
    @Autowired
    private HotelBookingRepository BookingRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.BookingRepository.findByNumber(1).isPresent());
        HotelBookingEntity firstBooking = this.BookingRepository.findByNumber(1).get();
    }
}
