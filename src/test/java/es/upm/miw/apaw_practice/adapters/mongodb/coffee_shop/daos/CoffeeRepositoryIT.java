package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.CoffeeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestConfig
public class CoffeeRepositoryIT {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Test
    void testFindByName() {
        assertTrue(this.coffeeRepository.findByCoffee("caffé americano").isPresent());
        CoffeeEntity coffee = this.coffeeRepository.findByCoffee("caffé americano").get();
        assertEquals("caffé americano", coffee.getCoffee());
        assertEquals("Espresso & Classic",coffee.getCategory());
        assertEquals(new BigDecimal("5.00"),coffee.getPrice());
    }
}
