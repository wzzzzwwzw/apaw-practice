package es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.AreaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class AreaRepositoryIT {

    @Autowired
    private AreaRepository areaRepository;

    @Test
    void testFindByName() {
        assertTrue(this.areaRepository.findByName("Area 1").isPresent());
        AreaEntity area = this.areaRepository.findByName("Area 1").get();
        assertEquals("Location 1", area.getLocation());
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.areaRepository.findAll().stream()
                .anyMatch(area ->
                        "Area 1".equals(area.getName()) &&
                                "Location 1".equals(area.getLocation()) &&
                                area.getEasyAccess() &&
                                2 == area.getRouteEntities().size() &&
                                "Route 1".equals(area.getRouteEntities().get(0).getName()) &&
                                "Easy".equals(area.getRouteEntities().get(0).getDifficulty())
                ));
    }
}
