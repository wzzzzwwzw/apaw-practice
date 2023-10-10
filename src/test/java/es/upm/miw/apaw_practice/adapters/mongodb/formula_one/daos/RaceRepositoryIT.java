package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.RaceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class RaceRepositoryIT {

    @Autowired
    private RaceRepository raceRepository;

    @Test
    void testFindByCircuitName() {
        assertTrue(this.raceRepository.findByCircuitName("Albert Park").isPresent());
        RaceEntity race = this.raceRepository.findByCircuitName("Albert Park").get();
        race.setNightRace(false);
        race.setLaps(58);

        assertEquals("Albert Park", race.getCircuitName());
        assertEquals("Australia", race.getHostCountry());
        assertEquals(LocalDate.of(2023, 4, 2), race.getDate());
        assertTrue(
                race.getRaceDriverEntities().stream()
                        .anyMatch(driver ->
                                driver.getDriverName().equals("Fernando Alonso") &&
                                        driver.getNumber() == 14 &&
                                        driver.getNationality().equals("Spain")
                        )
        );
        assertEquals(false, race.isNightRace());
        assertEquals(58, race.getLaps());
    }
}

