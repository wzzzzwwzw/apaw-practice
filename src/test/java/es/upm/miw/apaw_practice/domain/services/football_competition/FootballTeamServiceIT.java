package es.upm.miw.apaw_practice.domain.services.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestConfig
public class FootballTeamServiceIT {
    @Autowired
    private FootballTeamService footballTeamService;

    @Test
    public void testGetFootballTeamByCity() {
        FootballTeam team = this.footballTeamService.read("Madrid");
        assertNotNull(team);
        assertEquals("Madrid", team.getCity());
        assertEquals(1900, team.getFoundationYear());
        assertEquals(new BigDecimal("1238333.23"), team.getBudget());
        assertEquals(false, team.isRemoved());
    }

    @Test
    public void testCreateFootballTeam() {
        FootballTeam team = new FootballTeam("Zamora", 1890, new BigDecimal("174844.75"), false);
        assertNotNull(this.footballTeamService.create(team));
        assertNotNull(this.footballTeamService.read("Zamora"));
    }
}
