package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
