package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FlightPersistenceMongodbIT {

    @Autowired
    private FlightPersistenceMongodb flightPersistenceMongodb;

    @Test
    void testCreate() {
        List<Passenger> passengerList = new ArrayList<>();
        List<Aircraft> aircraftList = new ArrayList<>();
        Integer numberOfFlight = 875858;
        AirLine airLine = new AirLine("Iberia", LocalDate.of(1927, 6, 28),aircraftList);
        Flight flight =
                new Flight(numberOfFlight, LocalDate.of(2023,10,10),passengerList, airLine);

        assertEquals(875858, flight.getNumberOfFlight());
        assertEquals(LocalDate.of(2023,10,10),flight.getDateOfFlight());
        assertEquals("Iberia", flight.getAirLine().getName());
    }

    @Test
    void testExistFlight(){
        assertTrue(this.flightPersistenceMongodb.existFlight(12345));
        assertFalse(this.flightPersistenceMongodb.existFlight(545476));
    }
    @Test
    void testSearch(){
       assertTrue( this.flightPersistenceMongodb.findAirlineNameByPassengerAgeGreaterThan(80).toList().isEmpty());
    }
    @Test
    void test2Search(){
        assertTrue(this.flightPersistenceMongodb.findAirlineNameByPassengerAgeGreaterThan(70).toList().contains("Iberia"));
        assertEquals(1,this.flightPersistenceMongodb.findAirlineNameByPassengerAgeGreaterThan(70).toList().size());
    }
}
