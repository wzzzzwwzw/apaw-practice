package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.VideogameCompanySeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class FeaturePersistenceMongodbIT {
    private static final String GAME_GENRE = "Strategy";

    @Autowired
    private FeaturePersistenceMongodb featurePersistenceMongodb;

    @Autowired
    private VideogameCompanySeederService videogameCompanySeederService;

    @AfterEach
    void resetDatabase(){
        this.videogameCompanySeederService.deleteAll();
        this.videogameCompanySeederService.seedDatabase();
    }

    @Test
    void testReadByGenre(){
        Feature feature = this.featurePersistenceMongodb.readByGenre(GAME_GENRE);
        assertEquals("Real Time", feature.getGameStyle());
        assertEquals(false,feature.getCloudSynchronization());
    }

    @Test
    void testReadByGenreNotFound(){
        assertThrows(NotFoundException.class, ()-> this.featurePersistenceMongodb.readByGenre("Horror"));
    }

    @Test
    void testUpdateCloudSynchronization(){
        Feature feature = this.featurePersistenceMongodb.readByGenre(GAME_GENRE);
        feature.setCloudSynchronization(true);
        this.featurePersistenceMongodb.updateCloudSynchronization(feature);
        Feature updatedFeature = this.featurePersistenceMongodb.readByGenre(GAME_GENRE);
        assertEquals(true, updatedFeature.getCloudSynchronization());
    }

    @Test
    void testUpdateCloudSynchronizationNotFound(){
        Feature newFeature = new Feature("Horror", "Hack and Slash", false);
        assertThrows(NotFoundException.class,
                () -> this.featurePersistenceMongodb.updateCloudSynchronization(newFeature));
    }
}
