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
        assertTrue(this.BookingRepository.findByNumber(6).isPresent());
        HotelBookingEntity firstBooking = this.BookingRepository.findByNumber(6).get();
        assertEquals(firstBooking.getNumber(), 6);
        assertEquals(firstBooking.getRoomNumber(), 385);
        assertEquals(firstBooking.getDate(), LocalDate.of(2023, 12, 31));
        assertEquals(firstBooking.getCost(), new BigDecimal("39.99"));
        assertNotNull(firstBooking.getClient());
    }
}
