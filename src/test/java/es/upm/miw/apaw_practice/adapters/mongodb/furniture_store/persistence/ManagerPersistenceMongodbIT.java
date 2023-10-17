package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.FurnitureStoreSeederService;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ManagerPersistenceMongodbIT {

    @Autowired
    private ManagerPersistenceMongodb managerPersistenceMongodb;
    @Autowired
    private FurnitureStoreSeederService furnitureStoreSeederService;

    @Test
    void testUpdateSurname() {
        Manager manager = this.managerPersistenceMongodb.updateName("123456789012", "Roberto");
        assertNotNull(manager);
        assertEquals("123456789012", manager.getAffiliationNumber());
        assertEquals("Roberto", manager.getName());
        assertTrue(manager.getPromotionCandidate());

        this.furnitureStoreSeederService.deleteAll();
        this.furnitureStoreSeederService.seedDatabase();
    }
}
