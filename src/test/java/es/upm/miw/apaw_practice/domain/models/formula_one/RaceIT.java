package es.upm.miw.apaw_practice.domain.models.formula_one;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RaceIT {

    @Test
    void testRaceBuilder() {
        Race race = new Race.Builder()
                .circuitName("Spa-francorchamps")
                .hostCountry("Belgium")
                .date(LocalDate.of(2023, 7, 30))
                .laps(44)
                .nightRace(false)
                .build();
        assertNotNull(race);
        assertEquals("Spa-francorchamps", race.getCircuitName());
        assertEquals("Belgium", race.getHostCountry());
        assertEquals(LocalDate.of(2023, 7, 30), race.getDate());
        assertNull(race.getRaceDrivers());
        assertEquals(44, race.getLaps());
        assertEquals(false, race.isNightRace());
    }
}
