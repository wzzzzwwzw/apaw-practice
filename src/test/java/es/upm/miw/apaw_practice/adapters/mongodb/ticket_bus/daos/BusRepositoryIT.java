package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.BusEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.PassengerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TripEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class BusRepositoryIT {

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private TripRepository tripRepository;


    @Test
    void testFindByReferenceBus() {
        assertTrue(this.busRepository.findByReferenceBus("C-123").isPresent());
        BusEntity bus = this.busRepository.findByReferenceBus("C-123").get();
        assertFalse(bus.isAccessibility());
        TripEntity trip = new TripEntity("Madrid-Toledo", "17:00");
        assertEquals(trip, bus.getTrip());

    }

    @Test
    void testFindByTrip() {
        TripEntity trip = this.tripRepository.findByPath("Madrid-Toledo")
                .orElseThrow(() -> new NotFoundException("Trip not found"));
        List<BusEntity> buses = this.busRepository.findByTrip(trip);
        assertEquals(1, buses.size());
    }
}
