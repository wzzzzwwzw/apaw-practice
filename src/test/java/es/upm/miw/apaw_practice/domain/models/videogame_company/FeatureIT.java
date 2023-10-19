package es.upm.miw.apaw_practice.domain.models.videogame_company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FeatureIT {

    @Test
    void testFeatureBuilder(){
        Feature feature = Feature.build()
                .genre("Dungeon Crawler")
                .gameStyle("Turn Based")
                .cloudSynchronization(false)
                .build();
        assertNotNull(feature);
        assertEquals("Dungeon Crawler",feature.getGenre());
        assertEquals("Turn Based",feature.getGameStyle());
        assertEquals(false,feature.getCloudSynchronization());
    }
}
