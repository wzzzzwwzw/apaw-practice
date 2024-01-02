package es.upm.miw.apaw_practice.domain.models.restaurant.builders;

import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;

public interface IngredientBuilders {

    interface Name {
        Optionals name(String name);
    }

    interface Optionals {
        Optionals spicy(Boolean spicy);

        Optionals available(Boolean available);

        Ingredient build();
    }
}
