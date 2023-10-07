package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface DishPersistence {

    Stream<Dish> readAll();

    Dish update(Dish dish);

    Dish readByTitle(String title);
}
