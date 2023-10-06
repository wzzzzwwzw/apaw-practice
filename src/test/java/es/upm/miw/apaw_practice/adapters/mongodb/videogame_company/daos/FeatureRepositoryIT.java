package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class FeatureRepositoryIT{
    @Autowired
    private FeatureRepository featureRepository;

    @Test
    void testCreateAndRead(){
        assertTrue(this.featureRepository.findAll().stream()
                .anyMatch(feature ->
                        feature.getGenre().equals("Survival") &&
                                feature.getGameStyle().equals("Puzzle") &&
                                feature.getCloudSynchronization().equals(true)));
    }
}
