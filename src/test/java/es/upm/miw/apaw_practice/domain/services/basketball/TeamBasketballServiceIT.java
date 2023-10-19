package es.upm.miw.apaw_practice.domain.services.basketball;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class TeamBasketballServiceIT {

    @Autowired
    private TeamBasketballService teamBasketballService;
    @Test
    void testReadBasketballTeam() {
        Team team = this.teamBasketballService.read("alias1");
        assertNotNull(team);
        assertEquals("alias1", team.getAlias());
        assertEquals("Alberto", team.getCoach());
        assertEquals(2, team.getNumPlayers());
    }
}
