package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos.CoffeeRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop.CoffeePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("coffeePersistence")
public class CoffeePersistenceMongo implements CoffeePersistence {
    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeePersistenceMongo(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public Coffee read(String name) {
        return this.coffeeRepository
                .findByCoffee(name)
                .orElseThrow(() -> new NotFoundException("Coffee name: " + name))
                .toCoffee();
    }
}
