package es.upm.miw.apaw_practice.domain.services.hotel;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class HotelClientServiceIT {
    @Autowired
    private HotelClientService clientService;

    @Autowired
    private HotelSeederService hotelSeeder;

    @AfterEach
    public void resetDataBase() {
        this.hotelSeeder.deleteAll();
        this.hotelSeeder.seedDatabase();
    }

    @Test
    void testDeleteClient(){
        assertTrue(this.clientService.existClient("11122233C"));
        clientService.deleteClient("11122233C");
        assertFalse(this.clientService.existClient("11122233C"));
    }
}
