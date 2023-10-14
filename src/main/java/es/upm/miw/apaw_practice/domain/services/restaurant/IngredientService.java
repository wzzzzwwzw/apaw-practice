package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.DishPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.IngredientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private final IngredientPersistence ingredientPersistence;
    private final DishPersistence dishPersistence;

    @Autowired
    public IngredientService(IngredientPersistence ingredientPersistence, DishPersistence dishPersistence) {
        this.ingredientPersistence = ingredientPersistence;
        this.dishPersistence = dishPersistence;
    }

    public Ingredient findByName(String name) {
        return this.ingredientPersistence.findByName(name);
    }

    public List<String> findAllIngredientNamesByCategoryColor(String color) {
        return this.dishPersistence.findAllDishesByCategoryColor(color)
                .stream()
                .map(Dish::getIngredients)
                .flatMap(List::stream)
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

}
