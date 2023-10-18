package es.upm.miw.apaw_practice.domain.services.olympic_games;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.OlympicGamesSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Medal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class MedalServiceIT {
    @Autowired
    private MedalService medalService;
    @Autowired
    OlympicGamesSeederService olympicGamesSeederService;

    @Test
    void testReadByMedalID() {
        Medal medal = this.medalService.readByMedalId("MED111");
        assertEquals("Gold", medal.getTier());
        assertEquals(true, medal.getTeamMedal());
        assertEquals("Basketball", medal.getCompetition());
        assertEquals("Lebron", medal.getWinner().getName());
    }

    @Test
    void testReadByMedalIdError() {
        assertThrows(NotFoundException.class, () -> this.medalService.readByMedalId("MED238"));
    }

    @Test
    void testUpdateWinner() {
        Medal medal = this.medalService.readByMedalId("MED111");
        Competitor winner = new Competitor("Keria", "Korea", 20);
        medal.setWinner(winner);
        this.medalService.updateWinner(medal.getMedalID(), winner);
        medal = this.medalService.readByMedalId("MED111");
        assertEquals("Keria", medal.getWinner().getName());
        olympicGamesSeederService.reSeedDatabase();
    }
}
