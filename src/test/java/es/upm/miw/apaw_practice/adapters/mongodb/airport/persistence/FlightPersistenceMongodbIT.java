package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class FlightPersistenceMongodbIT {

    @Autowired
    private FlightPersistenceMongodb flightPersistenceMongodb;

    @Test
    void testCreateAndRead() {
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
}
