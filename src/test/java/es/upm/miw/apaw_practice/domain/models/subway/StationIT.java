package es.upm.miw.apaw_practice.domain.models.subway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StationIT {

    @Test
    void testStationBuilder() {
        Station station = new Station.Builder()
                .name("Canal")
                .order("1")
                .open(true)
                .build();
        assertNotNull(station);
        assertEquals("Canal", station.getName());
        assertEquals("1", station.getOrder());
        assertEquals(true, station.isOpen());
    }
}
