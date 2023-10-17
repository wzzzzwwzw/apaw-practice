package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FootballTeamRepositoryIT {
    @Autowired
    private FootballTeamRepository footballTeamRepository;
    @Autowired
    private FootballCompetitionSeederService footballCompetitionSeederService;

    @Test
    void testFindByCity() {
        assertTrue(this.footballTeamRepository.findByCity("Barcelona").isPresent());
        FootballTeam team = this.footballTeamRepository.findByCity("Barcelona").get().toFootballTeam();
        assertEquals(1892, team.getFoundationYear());
        assertEquals(new BigDecimal("3929210.34"), team.getBudget());
        assertEquals(false, team.isRemoved());
    }
}
