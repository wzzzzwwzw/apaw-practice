package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.MaterialEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class MaterialRepositoryIT {

    @Autowired
    private MaterialRepository materialRepository;

    @Test
    void testFindByName() {
        assertTrue(this.materialRepository.findByName("laminado").isPresent());
        MaterialEntity materialEntity = this.materialRepository.findByName("laminado").get();
        assertEquals("vidrio", materialEntity.getType());
        assertEquals(4, materialEntity.getDurability());
    }

}
