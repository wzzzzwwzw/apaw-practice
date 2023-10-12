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
        assertTrue(this.diningRepository.findByDiningNumber("1").isPresent());
        DiningEntity dining = this.diningRepository.findByDiningNumber("1").get();
        assertEquals("1", dining.getDiningNumber());
        assertEquals("location1", dining.getLocation());
        assertEquals(6, dining.getCapacity());
    }
}
