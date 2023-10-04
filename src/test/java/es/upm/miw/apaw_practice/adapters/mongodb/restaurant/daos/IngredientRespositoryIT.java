package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.IngredientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class IngredientRespositoryIT {

    @Autowired
    private IngredientRepository ingredientRepository;
    private static final String NAME = "Lubina";

    @Test
    void testFindByName() {
        assertTrue(ingredientRepository.findByName(NAME).isPresent());
        IngredientEntity ingredient = ingredientRepository.findByName(NAME).get();
        assertEquals(NAME, ingredient.getName());
    }

}
