package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class PassengerPersistenceMongodbIT {
    @Autowired
    private PassengerPersistenceMongodb passengerPersistenceMongodb;

    @Test
    void testReadByPassengerName(){
        Passenger passenger = this.passengerPersistenceMongodb.readByName("Carmen Moreno");
        assertEquals(20, passenger.getAge());
        assertEquals("6280942123", passenger.getNumberOfPhone());
    }
    @Test
    void testReadNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.passengerPersistenceMongodb.readByName("Alberto");
        });
        assertTrue(exception.getMessage().contains("Passenger name: Alberto"));
    }
}
