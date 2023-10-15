package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.FruitShopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitShopEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class FruitShopRepositoryIT {
    @Autowired
    private FruitShopRepository fruitShopRepository;
    @Autowired
    private FruitShopSeederService fruitShopSeederService;

    @BeforeEach
    void CleanUpDB() {
        this.fruitShopSeederService.deleteAll();
        this.fruitShopSeederService.seedDatabase();
    }

    @Test
    void testFruitFindByName() {

        assertTrue(this.fruitShopRepository.findByName("Fruit Haven").isPresent());
        FruitShopEntity fruitShop = this.fruitShopRepository.findByName("Fruit Haven").get();
        assertEquals("Barcelona", fruitShop.getAddress());
        assertTrue(
                fruitShop.getFruitEntities().stream()
                        .anyMatch(fruit ->
                                fruit.getType().equals("Mango") &&
                                        fruit.getUnitPrice().equals(new BigDecimal("7.5")) &&
                                        fruit.isTropical().equals(true) &&
                                        fruit.getStockTime().equals(LocalDate.of(2023, 1, 18))&&
                                        fruit.getFruitSpecieEntity().getSpecie().equals("Tropical")
                                )
        );
        assertEquals(1, fruitShop.getFruitEntities().size());

    }
}
