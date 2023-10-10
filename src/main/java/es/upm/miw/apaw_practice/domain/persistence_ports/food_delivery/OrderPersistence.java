package es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery;


import es.upm.miw.apaw_practice.domain.models.food_delivery.Order;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPersistence {
    Order read(Integer number);

    Order update(Integer number, Order order);
}
