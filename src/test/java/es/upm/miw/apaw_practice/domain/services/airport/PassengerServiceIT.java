package es.upm.miw.apaw_practice.domain.services.airport;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.AirportSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import es.upm.miw.apaw_practice.domain.services.formula_one.RaceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class PassengerServiceIT {
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private AirportSeederService airportSeederService;
    @AfterEach
    void resetDataBase() {
        this.airportSeederService.deleteAll();
        this.airportSeederService.seedDatabase();
    }
    @Test
    void testRead() {
        Passenger passenger = this.passengerService.read("Carmen Moreno");
        assertEquals("Carmen Moreno", passenger.getName());
        assertEquals(20, passenger.getAge());
        assertEquals("6280942123", passenger.getNumberOfPhone());
    }

    @Test
    void testReadNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.passengerService.read("Alberto");
        });
        assertTrue(exception.getMessage().contains("Passenger name: Alberto"));
    }
}
