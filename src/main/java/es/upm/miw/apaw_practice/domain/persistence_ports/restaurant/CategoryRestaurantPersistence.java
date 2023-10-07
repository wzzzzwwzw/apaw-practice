package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.CategoryRestaurant;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRestaurantPersistence {

    CategoryRestaurant create(CategoryRestaurant categoryRestaurant);

}
