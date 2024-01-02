package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class FootballTeamPersistenceMongodbIT {
    @Autowired
    private FootballTeamPersistenceMongodb footballTeamPersistence;
    @Autowired
    private FootballCompetitionSeederService footballCompetitionSeederService;

    @AfterEach
    void after() {
        this.footballCompetitionSeederService.deleteAll();
        this.footballCompetitionSeederService.seedDatabase();
    }

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.footballTeamPersistence.read("Bilbao"));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.footballTeamPersistence.read("Madrid"));
    }

    @Test
    void testCreateFootballTeam() {
        FootballTeam team = new FootballTeam("Albacete", 1890, new BigDecimal("174844.75"), false);
        assertNotNull(this.footballTeamPersistence.create(team));
        assertNotNull(this.footballTeamPersistence.read("Albacete"));
    }
}
