package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.TeamEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TeamRepositoryIT {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void testFindByTeamName() {
        assertTrue(this.teamRepository.findByTeamName("Mercedes").isPresent());
        TeamEntity team = this.teamRepository.findByTeamName("Mercedes").get();
        team.setMainColor("Black");

        assertEquals("Mercedes", team.getTeamName());
        assertEquals("Germany", team.getCountry());
        assertTrue(
                team.getDriverEntities().stream()
                        .anyMatch(driver ->
                                driver.getDriverName().equals("Lewis Hamilton") &&
                                        driver.getNumber() == 44 &&
                                        driver.getNationality().equals("United Kingdom")
                        )
        );
        assertEquals("Mercedes", team.getEngineManufacturerEntity().getManufacturerName());
        assertEquals("United Kingdom", team.getEngineManufacturerEntity().getEngineBuiltIn());
        assertEquals(12, team.getEngineManufacturerEntity().getNumberOfEnginesSupplied());
        assertEquals("Black", team.getMainColor());
    }

    @Test
    void testFindByTeamNameNotFound() {
        assertTrue(this.teamRepository.findByTeamName("Alpha Tauri").isEmpty());
    }

    @Test
    void testDeleteByTeamName() {
        assertTrue(this.teamRepository.findByTeamName("Williams").isPresent());
        this.teamRepository.deleteByTeamName("Williams");
        assertTrue(this.teamRepository.findByTeamName("Williams").isEmpty());
    }
}
