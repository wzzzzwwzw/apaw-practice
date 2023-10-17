package es.upm.miw.apaw_practice.adapters.mongodb.stable.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.KeeperEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class KeeperRepositoryIT {
    @Autowired
    private KeeperRepository keeperRepository;
    @Test
    void testCreateAndRead() {
        assertTrue(this.keeperRepository.findByName("Keeper1").isPresent());
        KeeperEntity keeperEntity = this.keeperRepository.findByName("Keeper1").get();
        assertEquals(26, keeperEntity.getAge());
        assertEquals(LocalDate.of(2010, 1, 1), keeperEntity.getHireDate());
        assertEquals(21000, keeperEntity.getSalary());
    }
}
