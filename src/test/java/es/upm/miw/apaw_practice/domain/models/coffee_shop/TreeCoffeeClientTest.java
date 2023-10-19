package es.upm.miw.apaw_practice.domain.models.coffee_shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TreeCoffeeClientTest {
    @Test
    void testTreeCoffeeClientsComposite() {
        CoffeeClientsComposite coffeeClientsComposite = new CoffeeClientsComposite("compositeTest");
        Assertions.assertTrue(coffeeClientsComposite.isComposite());

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("6", new BigDecimal("60.00"), LocalDateTime.of(2023, 1, 6, 12, 0, 0)));
        List<Coffee> coffees = new ArrayList<>();
        coffees.add(new Coffee("compositeCoffee", "compositeCategory", new BigDecimal("6.00")));
        Dining dining = new Dining("6","location6",6);
        CoffeeClient coffeeClient = new CoffeeClient("name6", "address6", "666666666",transactions,coffees,dining );

        coffeeClientsComposite.add(coffeeClient);
        Assertions.assertEquals(1, coffeeClientsComposite.getTreeCoffeeClients().size());

        coffeeClientsComposite.remove(coffeeClient);
        Assertions.assertEquals(0, coffeeClientsComposite.getTreeCoffeeClients().size());
    }

    @Test
    void testTreeCoffeeClientsLeaf() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("6", new BigDecimal("60.00"), LocalDateTime.of(2023, 1, 6, 12, 0, 0)));
        List<Coffee> coffees = new ArrayList<>();
        coffees.add(new Coffee("compositeCoffee", "compositeCategory", new BigDecimal("6.00")));
        Dining dining = new Dining("6","location6",6);
        CoffeeClient coffeeClient = new CoffeeClient("name6", "address6", "666666666",transactions,coffees,dining );

        Assertions.assertFalse(coffeeClient.isComposite());
        Assertions.assertThrows(UnsupportedOperationException.class, () -> coffeeClient.add(coffeeClient));
    }

}
