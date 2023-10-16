package es.upm.miw.apaw_practice.domain.services.airport;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.AirportSeederService;
import es.upm.miw.apaw_practice.adapters.rest.airport.FlightResource;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FlightServiceIT {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirportSeederService airportSeederService;
    @AfterEach
    void resetDataBase() {
        this.airportSeederService.deleteAll();
        this.airportSeederService.seedDatabase();
    }
    @Test
    void testCreate() {
        List<Passenger> passengerList = new ArrayList<>();
        List<Aircraft> aircraftList = new ArrayList<>();
        Integer numberOfFlight = 875858;
        AirLine airLine = new AirLine("Iberia", LocalDate.of(1927, 6, 28),aircraftList);
        Flight flight =
                new Flight(numberOfFlight, LocalDate.of(2023,10,10),passengerList, airLine);
        Flight flight1 = this.flightService.create(flight);
        assertEquals(875858, flight1.getNumberOfFlight());
        assertEquals(LocalDate.of(2023,10,10),flight1.getDateOfFlight());
        assertEquals("Iberia", flight1.getAirLine().getName());
    }

    @Test
    void testExistFlight(){
        Flight flight =  new Flight(12345, LocalDate.of(2023,10,10),null, null);
        RuntimeException exception = assertThrows(ConflictException.class, () -> {
            this.flightService.create(flight);
        });
        assertTrue(exception.getMessage().contains("Flight exist: 12345"));
    }


}
