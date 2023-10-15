package es.upm.miw.apaw_practice.adapters.rest.climbing;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.climbing.AreaResource.*;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class AreaResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(AREAS + NAME_ID, "Area 1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Area.class)
                .value(Assertions::assertNotNull)
                .value(areaData -> {
                    assertEquals("Area 1", areaData.getName());
                    assertEquals("Location 1", areaData.getLocation());
                    assertTrue(areaData.getEasyAccess());
                    assertEquals(2, areaData.getRoutes().size());
                    assertEquals("Route 1", areaData.getRoutes().get(0).getName());
                    assertEquals("Easy", areaData.getRoutes().get(0).getDifficulty());
                    assertEquals("Route 2", areaData.getRoutes().get(1).getName());
                    assertEquals("Medium", areaData.getRoutes().get(1).getDifficulty());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(AREAS + NAME_ID, "Area XYZ")
                .exchange()
                .expectStatus().isNotFound();
    }
}
