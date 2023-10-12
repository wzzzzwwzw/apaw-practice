package es.upm.miw.apaw_practice.domain.services.formula_one;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class RaceServiceIT {

    @Autowired
    private RaceService raceService;

    @Test
    void testRead() {
        Race race = this.raceService.read("Albert Park");
        assertEquals("Albert Park", race.getCircuitName());
        assertEquals("Australia", race.getHostCountry());
        assertEquals(LocalDate.of(2023, 4, 2), race.getDate());
        assertTrue(
                race.getRaceDrivers().stream()
                        .anyMatch(driver ->
                                driver.getDriverName().equals("George Russell") &&
                                        driver.getNumber() == 63 &&
                                        driver.getNationality().equals("United Kingdom")
                        )
        );
    }

    @Test
    void testReadNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.raceService.read("Baku");
        });
        assertTrue(exception.getMessage().contains("Race with circuit: Baku"));
    }

    @Test
    void testUpdateLaps() {
        Race race = this.raceService.updateLaps("Hermanos Rodríguez", 70);
        assertEquals("Hermanos Rodríguez", race.getCircuitName());
        assertEquals("Mexico", race.getHostCountry());
        assertEquals(LocalDate.of(2023, 10, 29), race.getDate());
        assertTrue(
                race.getRaceDrivers().stream()
                        .anyMatch(driver ->
                                driver.getDriverName().equals("George Russell") &&
                                        driver.getNumber() == 63 &&
                                        driver.getNationality().equals("United Kingdom")
                        )
        );
        assertEquals(70, race.getLaps());
    }

    @Test
    void testUpdateLapsNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.raceService.updateLaps("Suzuka", 40);
        });
        assertTrue(exception.getMessage().contains("Race with circuit: Suzuka"));
    }
}
