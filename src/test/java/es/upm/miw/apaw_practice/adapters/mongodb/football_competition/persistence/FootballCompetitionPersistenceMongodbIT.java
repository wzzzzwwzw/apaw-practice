package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.FootballCompetitionSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballCompetition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FootballCompetitionPersistenceMongodbIT {
    @Autowired
    private FootballCompetitionPersistenceMongodb footballCompetitionPersistence;
    @Autowired
    private FootballCompetitionSeederService footballCompetitionSeederService;

    @AfterEach
    void after() {
        this.footballCompetitionSeederService.deleteAll();
        this.footballCompetitionSeederService.seedDatabase();
    }

    @Test
    public void testDeleteFootballCompetition() {
        String organizingEntity = "DBF";
        FootballCompetition competition = this.footballCompetitionPersistence.readByOrganizingEntity(organizingEntity);
        assertNotNull(competition);
        this.footballCompetitionPersistence.delete(organizingEntity);
        assertThrows(NotFoundException.class, () -> this.footballCompetitionPersistence.readByOrganizingEntity(organizingEntity));
    }

    @Test
    public void testGetNamesByOrganizingEntity() {
        String organizingEntity = "FFF";
        List<String> playerNames = this.footballCompetitionPersistence.getNamesByOrganizingEntity(organizingEntity);
        assertEquals(List.of("Luka Modric", "Lionel Messi"), playerNames);
    }
}
