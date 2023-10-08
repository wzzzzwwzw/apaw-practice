package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class RacePersistenceMongodbIT {

    @Autowired
    RacePersistenceMongodb racePersistenceMongodb;

    @Test
    void testFindByCircuitName() {
        Race race = this.racePersistenceMongodb.findByCircuitName("Albert Park");
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
