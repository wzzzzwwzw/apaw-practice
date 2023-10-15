package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.CoffeeClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;
@TestConfig
public class CoffeeClientPersistenceMongodbIT {

    @Autowired
    private CoffeeClientPersistenceMongodb coffeeClientPersistenceMongodb;

    @Test
    void testUpdateAddressByName() {
        CoffeeClient coffeeClient = this.coffeeClientPersistenceMongodb.updateAddressByName("client3");
        assertNotNull(coffeeClient);
        assertEquals("new address", coffeeClient.getAddress());
    }

    @Test
    void testUpdateAddressException() {
        assertThrows(NotFoundException.class, () -> this.coffeeClientPersistenceMongodb.updateAddressByName("test"));
    }

}
