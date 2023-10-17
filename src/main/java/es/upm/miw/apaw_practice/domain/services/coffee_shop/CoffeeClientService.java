package es.upm.miw.apaw_practice.domain.services.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.CoffeeClient;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Transaction;
import es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop.CoffeeClientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
        return this.coffeeClientPersistence.getCoffeeClientStreamByCategory(category)
                .flatMap(client -> client.getTransactions().stream())
                .map(Transaction::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<String> getUniqueLocationsByCoffee(String coffee) {
        return this.coffeeClientPersistence.getUniqueLocationsByCoffee(coffee);
    }

}
