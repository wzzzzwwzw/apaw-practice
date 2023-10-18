package es.upm.miw.apaw_practice.domain.models.ticket_bus;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class TripBuilderTest {

    @Test
    void testBuilder() {
        Trip trip = Trip.builder()
                .path("Madrid-Toledo")
                .departure("17:00")
                .arrive("18:00")
                .numStops("5").build();
        assertEquals("Madrid-Toledo", trip.getPath());
        assertEquals("17:00", trip.getDeparture());
        assertEquals("18:00", trip.getArrive());
        assertEquals("5", trip.getNumStops());

    }
}
