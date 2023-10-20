package es.upm.miw.apaw_practice.domain.services.basketball;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Player;
import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.TeamPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class TeamBasketballServiceIT {

    @Autowired
    private TeamBasketballService teamBasketballService;

    @Autowired
    private TeamPersistence teamPersistence;
    @Test
    void testUpdatePlayer() {
        Player player = new Player("email1@gmail.com", "pivot", 20);
        this.teamBasketballService.updatePlayer("alias1", player.getEmail(), player);
        Team team = this.teamPersistence.readByAlias("alias1");
        assertEquals("pivot", team.getPlayers().get(0).getPosition());
        assertEquals(20, team.getPlayers().get(0).getAge());
    }
    @Test
    void testReadBasketballTeam() {
        Team team = this.teamBasketballService.read("alias1");
        assertNotNull(team);
        assertEquals("alias1", team.getAlias());
        assertEquals("Alberto", team.getCoach());
        assertEquals(2, team.getNumPlayers());
    }
}
