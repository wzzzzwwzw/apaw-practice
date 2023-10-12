package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.CoffeeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.DiningEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestConfig
public class DiningRepositoryIT {
    @Autowired
    private DiningRepository diningRepository;

    @Test
    void testFindByName() {
        assertTrue(this.diningRepository.findByDiningNumber("2").isPresent());
        DiningEntity dining = this.diningRepository.findByDiningNumber("2").get();
        assertEquals("2", dining.getDiningNumber());
        assertEquals("location2", dining.getLocation());
        assertEquals(6, dining.getCapacity());
    }
}
