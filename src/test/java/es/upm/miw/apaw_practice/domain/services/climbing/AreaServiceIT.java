package es.upm.miw.apaw_practice.domain.services.climbing;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.models.climbing.Route;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.AreaPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class AreaServiceIT {

    @Autowired
    private AreaService areaService;

    @Autowired
    private AreaPersistence areaPersistence;

    @Test
    void testUpdateRoute() {
        Route route = new Route("1", "Route 3 updated", "Easy");
        this.areaService.updateRoute("Area 2", route.getKey(), route);
        Area area = this.areaPersistence.readByName("Area 2");
        assertEquals("Route 3 updated", area.getRoutes().get(0).getName());
        assertEquals("Easy", area.getRoutes().get(0).getDifficulty());
    }
}
