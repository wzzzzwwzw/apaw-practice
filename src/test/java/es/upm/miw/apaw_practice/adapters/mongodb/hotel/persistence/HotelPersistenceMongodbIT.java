package es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistance.HotelPersistenceMongodb;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class HotelPersistenceMongodbIT {
    @Autowired
    private HotelPersistenceMongodb hotelPersistence;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.hotelPersistence.readByName("-"));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.hotelPersistence.readByName("Diamond"));
    }

}

