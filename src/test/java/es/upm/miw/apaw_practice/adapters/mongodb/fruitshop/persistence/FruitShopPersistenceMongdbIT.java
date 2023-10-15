package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitShop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FruitShopPersistenceMongdbIT {
    @Autowired
    private FruitShopPersistenceMongdb fruitShopPersistenceMongdb;

    @Test
    void testUpdateFruitShopAddress() {
        FruitShop fruitShop = this.fruitShopPersistenceMongdb.updateAddress("Fruit Test");
        assertNotNull(fruitShop);
        assertEquals("Fruit Test", fruitShop.getName());
        assertEquals("New Address", fruitShop.getAddress());
    }

    @Test
    void testUpdateFruitShopException() {
        assertThrows(NotFoundException.class, () ->this.fruitShopPersistenceMongdb.updateAddress("test"));
    }

}
