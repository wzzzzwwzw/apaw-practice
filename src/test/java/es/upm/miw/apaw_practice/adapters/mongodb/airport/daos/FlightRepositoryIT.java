package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.FlightEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class FlightRepositoryIT {
    @Autowired
    private FlightRepository flightRepository;

    @Test
    void testFindByNumberOfFlight() {
        assertTrue(this.flightRepository.findByNumberOfFlight(12345).isPresent());
        FlightEntity flight = this.flightRepository.findByNumberOfFlight(12345).get();
        assertEquals("Iberia", flight.getAirLine().getName());
        assertEquals(LocalDate.of(2023, 6, 28), flight.getDateOfFlight());
    }
}
