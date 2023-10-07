package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import org.springframework.stereotype.Repository;

@Repository
public interface DishPersistence {

    Dish update(Dish dish);

    Dish readByTitle(String title);
}
