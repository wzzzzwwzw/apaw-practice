package es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelBookingEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class HotelBookingRepositoryIT {
    @Autowired
    private HotelBookingRepository BookingRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.BookingRepository.findByNumber(1).isPresent());
        HotelBookingEntity firstBooking = this.BookingRepository.findByNumber(1).get();
        assertEquals(firstBooking.getNumber(),1);
        assertEquals(firstBooking.getRoomNumber(),327);
        assertEquals(firstBooking.getDate(), LocalDate.of(2023,10,21));
        assertEquals(firstBooking.getCost(),new BigDecimal("49.99"));
        assertNotNull(firstBooking.getClient());
    }
}
