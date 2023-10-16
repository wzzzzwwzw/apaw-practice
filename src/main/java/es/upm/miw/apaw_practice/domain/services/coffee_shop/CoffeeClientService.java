package es.upm.miw.apaw_practice.domain.services.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.CoffeeClient;
import es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop.CoffeeClientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CoffeeClientService {
    private final CoffeeClientPersistence coffeeClientPersistence;
    @Autowired
    public CoffeeClientService(CoffeeClientPersistence coffeeClientPersistence) {
        this.coffeeClientPersistence = coffeeClientPersistence;
    }

    public void delete(String name) {
        this.coffeeClientPersistence.delete(name);
    }

    public CoffeeClient updateAddressByName(String name) {
        return this.coffeeClientPersistence.updateAddressByName(name);
    }

    public BigDecimal getTotalPriceByCategory(String category) {
        return this.coffeeClientPersistence.getTotalPriceByCategory(category);
    }

}
