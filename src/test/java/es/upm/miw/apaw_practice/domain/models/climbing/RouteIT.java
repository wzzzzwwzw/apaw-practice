package es.upm.miw.apaw_practice.domain.models.climbing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RouteIT {

    @Test
    void testRouteBuilder() {
        Route route1 = new Route.Builder()
                .name("Route 1")
                .difficulty("Medium")
                .build();
        assertNotNull(route1);
        assertEquals("Route 1", route1.getName());
        assertEquals("Medium", route1.getDifficulty());
    }
}
