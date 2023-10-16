package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class RacePersistenceMongodbIT {

    @Autowired
    private RacePersistenceMongodb racePersistenceMongodb;

    @Test
    void testReadByCircuitName() {
        Race race = this.racePersistenceMongodb.readByCircuitName("Albert Park");
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
    void testReadByCircuitNameNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.racePersistenceMongodb.readByCircuitName("Emilia Romagna");
        });
        assertTrue(exception.getMessage().contains("Race with circuit: Emilia Romagna"));
    }

    @Test
    void testUpdate() {
        Race originalRace = this.racePersistenceMongodb.readByCircuitName("Silverstone");
        assertNull(originalRace.getLaps());
        originalRace.setLaps(52);
        Race updatedRace = this.racePersistenceMongodb.update(originalRace);
        assertEquals(52, updatedRace.getLaps());
    }

    @Test
    void testUpdateNotFound() {
        Race race = new Race("Gilles Villeneuve", "Canada", LocalDate.of(2023, 6, 11), null);
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.racePersistenceMongodb.update(race);
        });
        assertTrue(exception.getMessage().contains("Race with circuit: Gilles Villeneuve"));
    }
}
