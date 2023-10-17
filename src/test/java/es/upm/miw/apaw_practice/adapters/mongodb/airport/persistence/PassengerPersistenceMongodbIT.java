package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.AirportSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class PassengerPersistenceMongodbIT {
    @Autowired
    private PassengerPersistenceMongodb passengerPersistenceMongodb;
    @Autowired
    private AirportSeederService airportSeederService;
    @AfterEach
    void resetDataBase() {
        this.airportSeederService.deleteAll();
        this.airportSeederService.seedDatabase();
    }
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

    @Test
    void testUpdate(){
        Passenger passenger = this.passengerPersistenceMongodb.readByName("Carmen Moreno");
        passenger.setNumberOfPhone("676580594");
        Passenger passengerUpdated = this.passengerPersistenceMongodb.update(passenger);
        assertEquals("676580594", passengerUpdated.getNumberOfPhone());
    }

}
