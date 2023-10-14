package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.persistence;

import es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop.CoffeeClientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeClientPersistenceMongodb {
    private final CoffeeClientPersistence coffeeClientPersistence;

    @Autowired
    public CoffeeClientPersistenceMongodb(CoffeeClientPersistence coffeeClientPersistence) {
        this.coffeeClientPersistence = coffeeClientPersistence;
    }

    public void delete(String name) {
        this.coffeeClientPersistence.delete(name);
    }
}
