package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class IngredientServiceIT {

    @Autowired
    private IngredientService ingredientService;

    @Test
    void testFindByNameService() {
        Ingredient ingredient = ingredientService.findByName("Pollo");
        assertNotNull(ingredient);
        assertFalse(ingredient.isSpicy());
        assertTrue(ingredient.isAvailable());
    }

    @Test
    void testFindAllIngredientNamesByCategoryColor() {
        List<String> ingredientNames = ingredientService.findAllIngredientNamesByCategoryColor("Azul");
        assertEquals(List.of("Arroz", "Lubina"), ingredientNames);
    }

}
