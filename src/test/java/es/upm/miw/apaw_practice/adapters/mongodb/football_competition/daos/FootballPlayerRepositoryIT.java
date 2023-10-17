package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballPlayerEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class FootballPlayerRepositoryIT {
    @Autowired
    private FootballPlayerRepository footballPlayerRepository;
    @Autowired
    private FootballCompetitionSeederService footballCompetitionSeederService;

    @AfterEach
    void after() {
        this.footballCompetitionSeederService.deleteAll();
        this.footballCompetitionSeederService.seedDatabase();
    }

    @Test
    void testFindByName() {
        String playerName = "Luka Modric";
        assertTrue(this.footballPlayerRepository.findByName(playerName).isPresent());
        FootballPlayerEntity player =
                this.footballPlayerRepository.findByName(playerName).get();

        assertEquals(playerName, player.getName());
        assertEquals(new BigDecimal("129283.23"), player.getSalary());
        assertEquals((float)1.74, player.getHeight());
        assertEquals(2, player.getGoals());
        assertEquals(15, player.getAssists());
        assertNotNull(player.getTeam());
    }
}
