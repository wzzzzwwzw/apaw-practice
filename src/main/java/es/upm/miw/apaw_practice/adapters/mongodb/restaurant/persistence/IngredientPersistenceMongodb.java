package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.IngredientRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.IngredientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ingredientPersistence")
public class IngredientPersistenceMongodb implements IngredientPersistence {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientPersistenceMongodb(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient findByName(String name) {
        return this.ingredientRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Ingredient name: " + name))
                .toIngredient();
    }
}
