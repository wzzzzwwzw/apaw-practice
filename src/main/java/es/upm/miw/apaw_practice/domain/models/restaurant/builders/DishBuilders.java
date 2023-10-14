package es.upm.miw.apaw_practice.domain.models.restaurant.builders;

import es.upm.miw.apaw_practice.domain.models.restaurant.CategoryRestaurant;
import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;

import java.math.BigDecimal;
import java.util.List;

public interface DishBuilders {
    interface Title {
        Optionals title(String title);
    }

    interface Optionals {
        Optionals price(BigDecimal price);

        Optionals category(CategoryRestaurant category);

        Optionals ingredients(List<Ingredient> ingredients);

        Dish build();
    }

}
