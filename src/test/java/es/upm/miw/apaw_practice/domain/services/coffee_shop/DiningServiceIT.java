package es.upm.miw.apaw_practice.domain.services.coffee_shop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Dining;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestConfig
public class DiningServiceIT {
    @Autowired
    private DiningService diningService;
    @Test
    void testCreateDining() {
        Dining dining = this.diningService.Create(new Dining("1","location1",6));
        assertNotNull(dining);
        assertEquals("1", dining.getDiningNumber());
        assertEquals("location1", dining.getLocation());
        assertEquals(6, dining.getCapacity());
    }
}
