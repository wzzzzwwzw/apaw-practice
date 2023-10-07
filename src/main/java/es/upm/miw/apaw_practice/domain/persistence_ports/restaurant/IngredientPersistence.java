package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientPersistence {

    Ingredient findByName(String name);
}
