package es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeePersistence {
    Coffee read(String name);
    Coffee update(Coffee coffee);

}
