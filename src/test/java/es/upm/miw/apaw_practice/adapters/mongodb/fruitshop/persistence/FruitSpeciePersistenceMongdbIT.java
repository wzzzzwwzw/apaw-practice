package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FruitSpeciePersistenceMongdbIT {

    @Autowired
    private FruitSpeciePersistenceMongdb fruitSpeciePersistenceMongdb;

    @Test
    void testCreateFruitSpecie() {
        FruitSpecie fruitSpecie = this.fruitSpeciePersistenceMongdb.create(new FruitSpecie("TestSpecie","TestSeason", 10));
        FruitSpecie creatFruitSpecie = this.fruitSpeciePersistenceMongdb.create(fruitSpecie);
        assertNotNull(creatFruitSpecie);
        assertEquals(fruitSpecie.getSpecie(), creatFruitSpecie.getSpecie());
        assertEquals(fruitSpecie.getSeason(),creatFruitSpecie.getSeason());
        assertEquals(fruitSpecie.getSize(),creatFruitSpecie.getSize());
    }

    @Test
    void testExistFruitSpecie() {
        assertTrue(this.fruitSpeciePersistenceMongdb.existSpecie("Tropical"));
    }

    @Test
    void testNotExistFruitSpecie() {
        assertFalse(this.fruitSpeciePersistenceMongdb.existSpecie("complicated"));
    }
}
