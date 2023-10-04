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
        assertTrue(this.raceRepository.findByCircuitName("Hermanos Rodríguez").isPresent());

        RaceEntity race = this.raceRepository.findByCircuitName("Hermanos Rodríguez").get();
        race.setNightRace(false);
        race.setLaps(71);

        assertEquals("Mexico", race.getHostCountry());
        assertEquals(LocalDate.of(2023, 10, 29), race.getDate());
        assertTrue(
                race.getDriverEntities().stream()
                        .anyMatch(driver ->
                                driver.getDriverName().equals("Fernando Alonso") &&
                                        driver.getNumber() == 14 &&
                                        driver.getNationality().equals("Spain")
                        )
        );
        assertEquals("Mexico", race.getHostCountry());
        assertEquals(false, race.isNightRace());
        assertEquals(71, race.getLaps());
    }
}

