package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

}
