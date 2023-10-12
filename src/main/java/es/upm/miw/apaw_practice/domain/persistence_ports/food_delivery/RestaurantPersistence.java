package es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery;

import es.upm.miw.apaw_practice.domain.models.food_delivery.Restaurant;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantPersistence {

    Restaurant create(Restaurant restaurant);

    boolean existName(String name);
}
