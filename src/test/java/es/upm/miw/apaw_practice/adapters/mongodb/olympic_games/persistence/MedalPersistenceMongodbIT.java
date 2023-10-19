package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.OlympicGamesSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Medal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class MedalPersistenceMongodbIT {

    @Autowired
    private MedalPersistenceMongodb medalPersistenceMongodb;

    @Autowired
    private OlympicGamesSeederService olympicGamesSeederService;

    @Test
    void testReadById() {
        Medal medal = this.medalPersistenceMongodb.readByMedalId("MED111");
        assertEquals("Gold", medal.getTier());
        assertEquals(true, medal.getTeamMedal());
        assertEquals("Basketball", medal.getCompetition());
        assertEquals("Lebron", medal.getWinner().getName());
    }

    @Test
    void testReadByIdError() {
        assertThrows(NotFoundException.class, () -> this.medalPersistenceMongodb.readByMedalId("MED238"));
    }

    @Test
    void testUpdate() {
        Medal medal = this.medalPersistenceMongodb.readByMedalId("MED111");
        Competitor winner = new Competitor("Keria", "Korea", 20);
        medal.setWinner(winner);
        this.medalPersistenceMongodb.update(medal);
        medal = this.medalPersistenceMongodb.readByMedalId("MED111");
        assertEquals("Keria", medal.getWinner().getName());
        olympicGamesSeederService.reSeedDatabase();
    }

    @Test
    void testFindCompetitorsByCompetition() {
        List<String> competitorsNames = this.medalPersistenceMongodb.findCompetitorsByCompetition("4x100m relays");
        assertEquals("Cristina", competitorsNames.get(0));
        assertEquals("Fernando", competitorsNames.get(1));
    }
}
