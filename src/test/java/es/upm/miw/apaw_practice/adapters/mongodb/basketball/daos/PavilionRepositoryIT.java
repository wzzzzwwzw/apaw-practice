package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.PavilionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class PavilionRepositoryIT {

    @Autowired
    private PavilionRepository pavilionRepository;

    @Test
    void testFindByName() {
        Optional<PavilionEntity> result = this.pavilionRepository.findByPavname("pavilion1");
        assertTrue(result.isPresent());
        assertEquals("direction1", result.get().getDirection());
        assertEquals(1000, result.get().getCapacity());
    }

    @Test
    void testCreateAndRead() {
        Optional<PavilionEntity> result = this.pavilionRepository.findByPavname("pavilion2");
        assertTrue(result.isPresent());
        assertEquals("direction2", result.get().getDirection());
        assertEquals(2000, result.get().getCapacity());
    }

}
