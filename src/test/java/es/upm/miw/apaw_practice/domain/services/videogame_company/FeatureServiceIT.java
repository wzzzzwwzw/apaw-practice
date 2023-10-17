package es.upm.miw.apaw_practice.domain.services.videogame_company;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.VideogameCompanySeederService;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class FeatureServiceIT {
    @Autowired
    private FeatureService featureService;

    @Autowired
    private VideogameCompanySeederService videogameCompanySeederService;

    @AfterEach
    void resetDatabase(){
        this.videogameCompanySeederService.deleteAll();
        this.videogameCompanySeederService.seedDatabase();
    }

    @Test
    void testUpdateCloudSynchronization(){
        Feature feature = this.featureService.updateCloudSynchronization("Strategy",true);
        assertEquals("Strategy", feature.getGenre());
        assertEquals("Real Time", feature.getGameStyle());
        assertEquals(true, feature.getCloudSynchronization());
    }
}
