package es.upm.miw.apaw_practice.domain.services.formula_one;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class RaceServiceIT {

    @Autowired
    private RaceService raceService;

    @Test
    void testFindByCircuitName() {
        Race race = this.raceService.findByCircuitName("Albert Park");
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
}
