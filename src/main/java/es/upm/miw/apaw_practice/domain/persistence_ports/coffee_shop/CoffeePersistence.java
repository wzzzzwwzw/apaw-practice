package es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;

public interface CoffeePersistence {
    Coffee read(String name);
    Coffee update(Coffee coffee);

}
