package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@TestConfig
public class CoffeePersistenceMongodbIT {
    @Autowired
    private CoffeePersistenceMongodb coffeePersistence;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.coffeePersistence.read(".."));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.coffeePersistence.read("caffé americano"));
    }

    @Test
    void testUpdate() {
        Coffee coffee = this.coffeePersistence.update(new Coffee("Mocha Frappuccino","Tea",new BigDecimal("6.50")));
        assertNotNull(coffee);
        assertEquals(new BigDecimal("6.50"), coffee.getPrice());
    }

}
