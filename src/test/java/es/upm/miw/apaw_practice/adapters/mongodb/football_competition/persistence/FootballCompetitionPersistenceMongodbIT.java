package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballCompetitionEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballCompetition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FootballCompetitionPersistenceMongodbIT {
    @Autowired
    private FootballCompetitionPersistenceMongodb footballCompetitionPersistence;

    @Test
    public void testDeleteFootballCompetition() {
        String organizingEntity = "DBF";
        FootballCompetition competition = this.footballCompetitionPersistence.readByOrganizingEntity(organizingEntity);
        assertNotNull(competition);
        this.footballCompetitionPersistence.delete(organizingEntity);
        assertThrows(NotFoundException.class, () -> this.footballCompetitionPersistence.readByOrganizingEntity(organizingEntity));
    }
}
