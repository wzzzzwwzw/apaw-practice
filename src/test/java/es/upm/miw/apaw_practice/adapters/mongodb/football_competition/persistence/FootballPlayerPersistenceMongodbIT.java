package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballPlayer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class FootballPlayerPersistenceMongodbIT {
    @Autowired
    private FootballPlayerPersistenceMongodb footballPlayerPersistence;

    @Test
    public void testUpdateGoals() {
        String playerName = "Lionel Messi";
        FootballPlayer player = this.footballPlayerPersistence.readByName(playerName);
        assertNotNull(player);
        assertEquals(25, player.getGoals());
        FootballPlayer updatedPlayer = this.footballPlayerPersistence.updateGoals(playerName, 30);
        assertNotNull(updatedPlayer);
        assertEquals(30, updatedPlayer.getGoals());
    }
}
