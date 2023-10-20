package es.upm.miw.apaw_practice.domain.services.climbing;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.ClimbingSeederService;
import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.models.climbing.Route;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.AreaPersistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class AreaServiceIT {

    @Autowired
    private AreaService areaService;
    @Autowired
    private AreaPersistence areaPersistence;
    @Autowired
    private ClimbingSeederService climbingSeederService;

    @AfterEach
    void resetDataBase() {
        this.climbingSeederService.deleteAll();
        this.climbingSeederService.seedDatabase();
    }

    @Test
    void testUpdateRoute() {
        Route route = new Route.Builder()
                .name("Route 4 updated")
                .difficulty("Easy")
                .key("4")
                .build();
        this.areaService.updateRoute("Area 2", route.getKey(), route);
        Area area = this.areaPersistence.readByName("Area 2");
        assertEquals("Route 4 updated", area.getRoutes().get(1).getName());
        assertEquals("Easy", area.getRoutes().get(1).getDifficulty());
    }

    @Test
    void testFindRouteNamesByClimberLevel() {
        String[] routeNames = this.areaService.findRouteNamesByClimberLevel("Beginner");
        assertEquals(4, routeNames.length);
        assertEquals("Route 1", routeNames[0]);
        assertEquals("Route 2", routeNames[1]);
        assertEquals("Route 3", routeNames[2]);
        assertEquals("Route 4", routeNames[3]);
    }
}
