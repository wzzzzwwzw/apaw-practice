package es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistance.HotelClientPersistenceMongodb;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class HotelClientPersistenceMongodbIT {
    @Autowired
    private HotelClientPersistenceMongodb hotelClientPersistence;

    @Autowired
    private HotelSeederService hotelSeeder;

    @AfterEach
    public void resetDataBase() {
        this.hotelSeeder.deleteAll();
        this.hotelSeeder.seedDatabase();
    }

    @Test
    void testDelete() {
        assertTrue(this.hotelClientPersistence.existsClient("11122233A"));
        this.hotelClientPersistence.deleteClient("11122233A");
        assertFalse(this.hotelClientPersistence.existsClient("11122233A"));
    }

}
