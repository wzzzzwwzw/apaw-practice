package es.upm.miw.apaw_practice.domain.services.coffee_shop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestConfig
public class CoffeeServiceIT {
    @Autowired
    private CoffeeService coffeeService;

    @Test
    void testReadService() {
        Coffee coffee = this.coffeeService.read("caffé americano");
        assertNotNull(coffee);
    }

    @Test
    void testUpdateService() {
        Coffee coffee = this.coffeeService.updateCoffee("Mocha Frappuccino",new BigDecimal("6.50"));
        assertEquals(new BigDecimal("6.50"), coffee.getPrice());
        this.coffeeService.updateCoffee("Mocha Frappuccino",new BigDecimal("6.00"));

    }

}
