package es.upm.miw.apaw_practice.domain.services.fruitshop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.FruitShopSeederService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class FruitShopServiceIT {
    @Autowired
    private  FruitShopService fruitShopService;

    @Autowired
    private FruitShopSeederService fruitShopSeederService;

    @BeforeEach
    void cleanUp(){
        this.fruitShopSeederService.deleteAll();
        this.fruitShopSeederService.seedDatabase();
    }

    @Test
    void testDelete() {
        fruitShopService.delete("Fruitful Delights");
    }

    @Test
    void testFindAddressByFruitSpeice() {
        List<String> specie = new LinkedList<>();
        specie.add("Malaga");
        assertEquals(specie,this.fruitShopService.findAddressByFruitSpecie("Normal").toList());
    }


}
