package es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistance.HotelPersistenceMongodb;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class HotelPersistenceMongodbIT {
    @Autowired
    private HotelPersistenceMongodb hotelPersistence;

    @Autowired
    private HotelSeederService hotelSeeder;

    @AfterEach
    public void resetDataBase() {
        this.hotelSeeder.deleteAll();
        this.hotelSeeder.seedDatabase();
    }

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.hotelPersistence.readByName("-"));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.hotelPersistence.readByName("Diamond"));
    }

}

