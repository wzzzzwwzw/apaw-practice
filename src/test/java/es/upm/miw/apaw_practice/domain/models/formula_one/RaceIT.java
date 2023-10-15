package es.upm.miw.apaw_practice.domain.models.formula_one;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RaceIT {

    @Test
    void testRaceBuilder() {
        List<Driver> raceDrivers = new ArrayList<>();
        Driver driver = new Driver.Builder()
                .number(16)
                .driverName("Charles Leclerc")
                .nationality("Monaco")
                .build();
        raceDrivers.add(driver);

        Race race = new Race.Builder()
                .circuitName("Spa-francorchamps")
                .hostCountry("Belgium")
                .date(LocalDate.of(2023, 7, 30))
                .raceDrivers(raceDrivers)
                .laps(44)
                .nightRace(false)
                .build();
        assertNotNull(race);
        assertEquals("Spa-francorchamps", race.getCircuitName());
        assertEquals("Belgium", race.getHostCountry());
        assertEquals(LocalDate.of(2023, 7, 30), race.getDate());
        assertTrue(race.getRaceDrivers().contains(driver));
        assertEquals(44, race.getLaps());
        assertEquals(false, race.isNightRace());
    }
}
