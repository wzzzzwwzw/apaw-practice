package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TripEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TripRepositoryIT {

    @Autowired
    private TripRepository tripRepository;

    @Test
    void testFindByPath() {
        assertTrue(this.tripRepository.findByPath("Madrid-Toledo").isPresent());
        TripEntity trip = this.tripRepository.findByPath("Madrid-Toledo").get();
        assertEquals("Madrid-Toledo", trip.getPath());
        assertEquals("17:00", trip.getDeparture());
    }

    @Test
    void testFindByDeparture() {
        assertTrue(this.tripRepository.findByDeparture("17:00").isPresent());
        TripEntity trip = this.tripRepository.findByDeparture("17:00").get();
        assertEquals("Madrid-Toledo", trip.getPath());
        assertEquals("17:00", trip.getDeparture());
    }
}
