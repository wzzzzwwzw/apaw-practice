package es.upm.miw.apaw_practice.domain.models.restaurant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientIT {

    @Test
    void testIngredientBuilder() {
        Ingredient ingredient = new Ingredient.Builder()
                .name("Ingrediente_prueba")
                .spicy(false)
                .available(true)
                .build();
        assertNotNull(ingredient);
        assertEquals("Ingrediente_prueba", ingredient.getName());
        assertFalse(ingredient.isSpicy());
        assertTrue(ingredient.isAvailable());
    }
}
