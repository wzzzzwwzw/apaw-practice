package es.upm.miw.apaw_practice.domain.models.furnitureStore;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Manager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ManagerIT {

    @Test
    void testManagerBuilder() {
        Manager manager = new Manager.Builder()
                .affiliationNumber("123456789123")
                .name("Rosa")
                .promotionCandidate(false)
                .build();
        assertNotNull(manager);
        assertEquals("123456789123", manager.getAffiliationNumber());
        assertEquals("Rosa", manager.getName());
        assertFalse(manager.getPromotionCandidate());
    }

}
