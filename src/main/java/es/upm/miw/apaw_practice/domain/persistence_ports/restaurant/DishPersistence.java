package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DishPersistence {

    Dish updatePrice(String title, BigDecimal price);
}
