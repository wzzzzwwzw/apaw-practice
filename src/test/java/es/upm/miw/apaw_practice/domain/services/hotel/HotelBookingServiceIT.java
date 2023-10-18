package es.upm.miw.apaw_practice.domain.services.hotel;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class HotelBookingServiceIT {
    @Autowired
    private HotelBookingService bookingService;

    @Test
    void testReadService(){
        HotelClient client = new HotelClient("11100033A","example@email.com",112222333,true);
        HotelBooking booking = new HotelBooking(20, 999, LocalDate.of(2023,10,21), new BigDecimal("49.99"), client);
        HotelBooking bookingCreated = bookingService.create(booking);
        assertNotNull(bookingCreated);
        assertEquals(bookingCreated.getNumber(), booking.getNumber());
        assertEquals(bookingCreated.getRoomNumber(), booking.getRoomNumber());
        assertEquals(bookingCreated.getDate(), booking.getDate());
        assertEquals(bookingCreated.getCost(), booking.getCost());
        assertNotNull(bookingCreated.getClient());
    }
}
