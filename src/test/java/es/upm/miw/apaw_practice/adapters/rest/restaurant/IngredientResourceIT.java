package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.restaurant.IngredientResource.*;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class IngredientResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testFindByName() {
        this.webTestClient
                .get()
                .uri(INGREDIENTS + NAME_ID, "Pollo")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Ingredient.class)
                .value(Assertions::assertNotNull)
                .value(ingredient -> {
                    assertEquals("Pollo", ingredient.getName());
                    assertFalse(ingredient.isSpicy());
                    assertTrue(ingredient.isAvailable());
                });
    }

    @Test
    void testFindByNameNotFound() {
        this.webTestClient
                .get()
                .uri(INGREDIENTS + NAME_ID, "unknown ingredient")
                .exchange()
                .expectStatus().isNotFound();
    }

}
