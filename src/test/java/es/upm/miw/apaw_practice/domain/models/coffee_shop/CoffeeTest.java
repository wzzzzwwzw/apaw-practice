package es.upm.miw.apaw_practice.domain.models.coffee_shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CoffeeTest {
    @Test
    void testCoffeeBuilder() {
        Coffee coffee = Coffee.builder()
                .coffeeName("New coffee")
                .category("New category")
                .price(new BigDecimal("5.00"))
                .build();

        Assertions.assertEquals("New coffee", coffee.getCoffee());
        Assertions.assertEquals("New category", coffee.getCategory());
        Assertions.assertEquals(new BigDecimal("5.00"), coffee.getPrice());
    }
}
