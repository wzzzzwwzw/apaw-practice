package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop;

import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos.CoffeeClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos.CoffeeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos.DiningRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.CoffeeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.DiningEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.CoffeeClientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.TransactionEntity;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Dining;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class CoffeeShopSeederService {
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeClientRepository coffeeClientRepository;
    @Autowired
    private DiningRepository diningRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Coffee Shop Initial Load -----------");
        CoffeeEntity[] coffees = {
                new CoffeeEntity(new Coffee("caffé americano", "Espresso & Classic",new BigDecimal("5.00"))),
                new CoffeeEntity(new Coffee("latte macchiato", "Espresso & Classic",new BigDecimal("4.50"))),
                new CoffeeEntity(new Coffee("cappuccino", "Tea",new BigDecimal("5.50"))),
                new CoffeeEntity(new Coffee("Expresso Frappuccino", "Frappuccino",new BigDecimal("6.00"))),
                new CoffeeEntity(new Coffee("Mocha Frappuccino", "Frappuccino",new BigDecimal("6.00")))
        };
        this.coffeeRepository.saveAll(Arrays.asList(coffees));
        DiningEntity[] dinings = {
                new DiningEntity(new Dining("1","location1",6)),
                new DiningEntity(new Dining("2","location2",6)),
                new DiningEntity(new Dining("3","location3",4)),
                new DiningEntity(new Dining("4","location4",2))
        };
        this.diningRepository.saveAll(Arrays.asList(dinings));

        TransactionEntity[] transactions = {
                new TransactionEntity("1", new BigDecimal("6.00"), LocalDateTime.of(2023, 1, 1, 12, 0, 0)),
                new TransactionEntity("2",new BigDecimal("12.00"),LocalDateTime.of(2023, 1, 2, 12, 0, 0)),
                new TransactionEntity("3",new BigDecimal("18.00"),LocalDateTime.of(2023, 1, 3, 12, 0, 0)),
                new TransactionEntity("4",new BigDecimal("24.00"),LocalDateTime.of(2023, 1, 4, 12, 0, 0)),
                new TransactionEntity("5",new BigDecimal("36.00"),LocalDateTime.of(2023, 1, 5, 12, 0, 0))
        };
        CoffeeClientEntity[] clients = {
                new CoffeeClientEntity("client1","address1","111111111",Arrays.asList(transactions[0], transactions[1]),Arrays.asList(coffees[0], coffees[1]),dinings[0]),
                new CoffeeClientEntity("client2","address2","222222222", List.of(transactions[2]),Arrays.asList(coffees[0], coffees[1]),dinings[1]),
                new CoffeeClientEntity("client3","address3","333333333", List.of(transactions[3]),Arrays.asList(coffees[1], coffees[2]),dinings[2]),
                new CoffeeClientEntity("client4","address4","444444444", List.of(transactions[4]),Arrays.asList(coffees[2], coffees[3]),dinings[3]),
        };
        this.coffeeClientRepository.saveAll(Arrays.asList(clients));
    }

    public void deleteAll() {
        this.coffeeRepository.deleteAll();
        this.diningRepository.deleteAll();
        this.coffeeClientRepository.deleteAll();
    }
}
