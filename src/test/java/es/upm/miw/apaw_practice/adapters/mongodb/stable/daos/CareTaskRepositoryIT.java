package es.upm.miw.apaw_practice.adapters.mongodb.stable.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.CareTaskEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class CareTaskRepositoryIT {
    @Autowired
    private CareTaskRepository careTaskRepository;
    @Test
    void testCreateAndRead() {
        assertTrue(this.careTaskRepository.findByDescription("Description1").isPresent());
        CareTaskEntity careTaskEntity = this.careTaskRepository.findByDescription("Description1").get();
        assertEquals(1.0, careTaskEntity.getDurationHours());
    }
}
