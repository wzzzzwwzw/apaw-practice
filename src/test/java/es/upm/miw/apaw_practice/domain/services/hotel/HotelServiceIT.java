package es.upm.miw.apaw_practice.domain.services.hotel;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class HotelServiceIT {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelSeederService hotelSeeder;

    @AfterEach
    public void resetDataBase() {
        this.hotelSeeder.deleteAll();
        this.hotelSeeder.seedDatabase();
    }

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
