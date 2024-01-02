package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

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

    @Test
    void testSearchIngredientsNameByCategoryColor() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(INGREDIENTS + SEARCH)
                                .queryParam("q", "color:Azul")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(Assertions::assertNotNull)
                .value(names -> assertEquals(List.of("Arroz", "Lubina"), names));
    }

    @Test
    void testNotSearchIngredientsNameByCategoryColor() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(INGREDIENTS + SEARCH)
                                .queryParam("q", "color:unknown_color")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(Assertions::assertNotNull)
                .value(names -> assertEquals(List.of(), names));
    }

    @Test
    void testSearchIngredientsNameByCategoryColorBadRequest() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(INGREDIENTS + SEARCH)
                                .queryParam("q", "colo:Azul")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }

}
