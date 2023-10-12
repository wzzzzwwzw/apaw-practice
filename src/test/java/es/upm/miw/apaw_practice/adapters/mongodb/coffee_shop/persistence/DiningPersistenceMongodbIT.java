package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Dining;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestConfig
public class DiningPersistenceMongodbIT {
    @Autowired
    private DiningPersistenceMongodb diningPersistence;
    @Test
    void testCreateDining() {
        Dining dining = this.diningPersistence.create(new Dining("1","location1",6));
        Dining createdDining = this.diningPersistence.create(dining);
        assertNotNull(createdDining);
        assertEquals(dining.getDiningNumber(), createdDining.getDiningNumber());
        assertEquals(dining.getLocation(), createdDining.getLocation());
        assertEquals(dining.getCapacity(), createdDining.getCapacity());
    }
}
