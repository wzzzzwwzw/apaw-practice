package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballTeamEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class FootballTeamPersistenceMongodbIT {
    @Autowired
    private FootballTeamPersistenceMongodb footballTeamPersistence;

    @Test
    public void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.footballTeamPersistence.read("Bilbao"));
    }

    @Test
    public void testReadFound() {
        assertNotNull(this.footballTeamPersistence.read("Madrid"));
    }

    @Test
    public void testCreateFootballTeam() {
        FootballTeam team = new FootballTeam("Albacete", 1890, new BigDecimal("174844.75"), false);
        assertNotNull(this.footballTeamPersistence.create(team));
        assertNotNull(this.footballTeamPersistence.read("Albacete"));
    }
}
