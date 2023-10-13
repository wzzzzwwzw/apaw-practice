package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos.CoffeeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.CoffeeEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop.CoffeePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("coffeePersistence")
public class CoffeePersistenceMongodb implements CoffeePersistence {
    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeePersistenceMongodb(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public Coffee read(String name) {
        return this.coffeeRepository
                .findByCoffee(name)
                .orElseThrow(() -> new NotFoundException("Coffee name: " + name))
                .toCoffee();
    }

    @Override
    public Coffee update(Coffee coffee) {
        CoffeeEntity coffeeEntity = this.coffeeRepository
                .findByCoffee(coffee.getCoffee())
                .orElseThrow(() -> new NotFoundException("Coffee name:" + coffee.getCoffee()));
        coffeeEntity.setPrice(coffee.getPrice());
        return this.coffeeRepository.save(coffeeEntity).toCoffee();
    }
}
