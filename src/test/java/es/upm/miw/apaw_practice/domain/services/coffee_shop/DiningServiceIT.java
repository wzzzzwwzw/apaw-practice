package es.upm.miw.apaw_practice.domain.services.coffee_shop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Dining;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class DiningServiceIT {
    @Autowired
    private DiningService diningService;
    @Test
    void testCreateDining() {
        Dining dining = this.diningService.Create(new Dining("CREATE_TEST","CREATE_TEST",6));
        assertNotNull(dining);
        assertEquals("CREATE_TEST", dining.getDiningNumber());
        assertEquals("CREATE_TEST", dining.getLocation());
        assertEquals(6, dining.getCapacity());
    }

    @Test
    void testCreateAlreadyExistsDining() {
        Dining dining = new Dining("1","location1",6);
        assertThrows(ConflictException.class, () -> this.diningService.Create(dining));
    }
}
