package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.FurnitureStoreSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class MaterialPersistenceMongodbIT {

    @Autowired
    private MaterialPersistenceMongodb materialPersistenceMongodb;

    @Autowired
    private FurnitureStoreSeederService furnitureStoreSeederService;

    @BeforeEach
    void resetDB() {
        this.furnitureStoreSeederService.deleteAll();
        this.furnitureStoreSeederService.seedDatabase();
    }

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.materialPersistenceMongodb.read("no existe"));
    }

    @Test
    void testNameNotExist() {
        assertFalse(this.materialPersistenceMongodb.existName("no existe"));
    }

    @Test
    void testNameExist() {
        assertTrue(this.materialPersistenceMongodb.existName("polipropileno"));
    }

    @Test
    void testCreateAndRead() {
        Material material =
                new Material("mármol", "piedra", 6);
        this.materialPersistenceMongodb.create(material);
        Material materialBD = this.materialPersistenceMongodb.read("mármol");
        assertEquals("piedra", materialBD.getType());
        assertEquals("mármol", materialBD.getName());
        assertEquals(6, materialBD.getDurability());
    }
}
