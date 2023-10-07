package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.IngredientPersistence;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    private final IngredientPersistence ingredientPersistence;

    public IngredientService(IngredientPersistence ingredientPersistence) {
        this.ingredientPersistence = ingredientPersistence;
    }

    public Ingredient findByName(String name) {
        return this.ingredientPersistence.findByName(name);
    }
}
