package es.upm.miw.apaw_practice.domain.services.football_competition;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballPlayer;
import es.upm.miw.apaw_practice.domain.persistence_ports.football_competition.FootballPlayerPersistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class FootballPlayerServiceIT {
    @Autowired
    private FootballPlayerService footballPlayerService;
    @Autowired
    FootballPlayerPersistence footballPlayerPersistence;
    @Autowired
    private FootballCompetitionSeederService footballCompetitionSeederService;

    @AfterEach
    void after() {
        this.footballCompetitionSeederService.deleteAll();
        this.footballCompetitionSeederService.seedDatabase();
    }

    @Test
    public void testUpdateGoals() {
        String playerName = "Lionel Messi";
        FootballPlayer player = this.footballPlayerPersistence.readByName(playerName);
        assertEquals(25, player.getGoals());
        this.footballPlayerService.updateGoals(player.getName(), 35);
        FootballPlayer updatedPlayer = this.footballPlayerPersistence.readByName(playerName);
        assertEquals(35, updatedPlayer.getGoals());
    }
}
