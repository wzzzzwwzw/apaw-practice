package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.FruitShopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitSpecieEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class FruitSpecieRepositoryIT {

    @Autowired
    private FruitSpecieRepository fruitSpecieRepository;

    @Autowired
    private FruitShopSeederService fruitShopSeederService;

    @AfterEach
    void CleanUpDB() {
        this.fruitShopSeederService.deleteAll();
        this.fruitShopSeederService.seedDatabase();
    }


    @Test
    void testCreateAndRead() {
        assertTrue(this.fruitSpecieRepository.findBySpecie("Tropical").isPresent());
        FruitSpecieEntity fruitSpecie = this.fruitSpecieRepository.findBySpecie("Tropical").get();
        assertEquals("Spring", fruitSpecie.getSeason());
        assertEquals(8, fruitSpecie.getSize());
   }

}


