package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.VideogameCompanySeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@TestConfig
public class VideogamePersistenceMongodbIT {
    private static final String VIDEOGAME_NAME = "Super Bomberman R";
    @Autowired
    private VideogamePersistenceMongodb videogamePersistenceMongodb;
    @Autowired
    private VideogameCompanySeederService videogameCompanySeederService;

    @AfterEach
    void resetDatabase(){
        this.videogameCompanySeederService.deleteAll();
        this.videogameCompanySeederService.seedDatabase();
    }

    @Test
    void testUpdateReleaseDate(){
        Videogame videogame = this.videogamePersistenceMongodb.updateReleaseDateByName(VIDEOGAME_NAME);
        assertNotNull(videogame);
        assertEquals("Super Bomberman R", videogame.getName());
        assertTrue(videogame.getReleaseDate().atStartOfDay().isEqual(LocalDate.now().atStartOfDay()));
    }

    @Test
    void testUpdateReleaseDateNotFound(){
        assertThrows(NotFoundException.class, () -> this.videogamePersistenceMongodb.updateReleaseDateByName("x"));
    }
}
