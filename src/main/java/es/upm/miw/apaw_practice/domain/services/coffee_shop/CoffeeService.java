package es.upm.miw.apaw_practice.domain.services.coffee_shop;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop.CoffeePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class CoffeeService {
    private final CoffeePersistence coffeePersistence;
    @Autowired
    public CoffeeService(CoffeePersistence coffeePersistence) {
        this.coffeePersistence = coffeePersistence;
    }
    public Coffee read(String name) {
        return this.coffeePersistence.read(name);
    }

    public Coffee updateCoffee(String name, BigDecimal price) {
        Coffee coffee = this.coffeePersistence.read(name);
        coffee.setPrice(price);
        return this.coffeePersistence.update(coffee);
    }
}
