package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.ManagerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ManagerRepositoryIT {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    void testFindByAffiliationNumber() {
        assertTrue(this.managerRepository.findByAffiliationNumber("456745674567").isPresent());
        ManagerEntity managerEntity = this.managerRepository.findByAffiliationNumber("456745674567").get();
        assertEquals("María", managerEntity.getName());
        assertTrue(managerEntity.getPromotionCandidate());
    }
}
