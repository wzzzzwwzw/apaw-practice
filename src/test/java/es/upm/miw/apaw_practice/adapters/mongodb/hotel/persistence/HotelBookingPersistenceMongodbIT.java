package es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistance.HotelBookingPersistenceMongodb;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class HotelBookingPersistenceMongodbIT {
    @Autowired
    private HotelBookingPersistenceMongodb hotelBookingPersistence;

    @Autowired
    private HotelSeederService hotelSeeder;

    @AfterEach
    public void resetDataBase() {
        this.hotelSeeder.deleteAll();
        this.hotelSeeder.seedDatabase();
    }

    @Test
    void testReadNotFound() {
        assertFalse(this.hotelBookingPersistence.existsBooking(-1));
    }

    @Test
    void testReadFound() {
        assertTrue(this.hotelBookingPersistence.existsBooking(1));
    }

    @Test
    void testCreateBooking() {
        HotelClient client = new HotelClient("21345155G", "example@email.com", 111222333, true);
        HotelBooking booking = new HotelBooking(10, 555, LocalDate.of(2023, 10, 21), new BigDecimal("49.99"), client);
        HotelBooking createdBooking = this.hotelBookingPersistence.create(booking);
        assertNotNull(createdBooking);
        assertEquals(createdBooking.getNumber(), 10);
        assertEquals(createdBooking.getRoomNumber(), 555);
        assertEquals(createdBooking.getDate(), LocalDate.of(2023, 10, 21));
        assertEquals(createdBooking.getCost(), new BigDecimal("49.99"));
        assertNotNull(createdBooking.getClient());
    }

    @Test
    void testCreateBookingConflict() {
        HotelClient client = new HotelClient("21345155G", "example@email.com", 111222333, true);
        HotelBooking booking = new HotelBooking(1, 555, LocalDate.of(2023, 10, 21), new BigDecimal("49.99"), client);
        assertThrows(ConflictException.class, () -> this.hotelBookingPersistence.create(booking));
    }

}
