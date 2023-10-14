package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.CoffeeShopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.CoffeeClientEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CoffeeClientRepositoryIT {
    @Autowired
    private CoffeeClientRepository coffeeClientRepository;
    @Autowired
    private CoffeeShopSeederService coffeeShopSeederService;

    @AfterEach
    void cleanUpDB() {
        this.coffeeShopSeederService.deleteAll();
        this.coffeeShopSeederService.seedDatabase();
    }
    @Test
    void testFindByName() {
        assertTrue(this.coffeeClientRepository.findByName("client1").isPresent());
        CoffeeClientEntity client = this.coffeeClientRepository.findByName("client1").get();
        assertEquals("client1", client.getName());
        assertEquals("address1",client.getAddress());
        assertEquals("111111111", client.getPhoneNumber());
        assertEquals("location1",client.getDiningEntity().getLocation());
        assertTrue(
                client.getCoffeesEntities().stream()
                        .anyMatch(coffee ->
                                coffee.getCoffee().equals("caffé americano")
                        )
        );
        assertTrue(
                client.getTransactionsEntities().stream()
                        .anyMatch(transaction ->
                                transaction.getOrder().equals("1")
                        )
        );
        assertTrue(
                client.getTransactionsEntities().stream()
                        .anyMatch(transaction ->
                                transaction.getTotalPrice().equals(new BigDecimal("6.00"))
                        )
        );
        assertTrue(
                client.getTransactionsEntities().stream()
                        .anyMatch(transaction ->
                                transaction.getPayDate().equals(LocalDateTime.of(2023, 1, 1, 12, 0, 0))
                        )
        );
    }

    @Test
    void testDeleteByName() {
        this.coffeeClientRepository.deleteByName("caffé americano");
        assertFalse(this.coffeeClientRepository.findByName("caffé americano").isPresent());
    }
}
