package es.upm.miw.apaw_practice.domain.models.restaurant.builders;

import es.upm.miw.apaw_practice.domain.models.restaurant.CategoryRestaurant;

import java.time.LocalDateTime;

public interface CategoryRestaurantBuilders {

    interface Tag {
        Optionals tag(String tag);
    }

    interface Optionals {
        Optionals color(String color);

        Optionals creationDate(LocalDateTime creationDate);

        CategoryRestaurant build();
    }
}
