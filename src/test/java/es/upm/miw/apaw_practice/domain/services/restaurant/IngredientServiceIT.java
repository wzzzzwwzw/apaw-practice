package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class IngredientServiceIT {

    @Autowired
    private IngredientService ingredientService;

    @Test
    void testFindByNameService(){
        Ingredient ingredient = ingredientService.findByName("Pollo");
        assertNotNull(ingredient);
        assertFalse(ingredient.isSpicy());
        assertTrue(ingredient.isAvailable());
    }

}
