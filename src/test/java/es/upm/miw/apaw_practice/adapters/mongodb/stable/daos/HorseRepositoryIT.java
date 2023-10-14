package es.upm.miw.apaw_practice.adapters.mongodb.stable.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.HorseEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.KeeperEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class HorseRepositoryIT {
    @Autowired
    private HorseRepository horseRepository;
    @Test
    void testFindByName() {
        assertTrue(this.horseRepository.findByName("name1").isPresent());
        HorseEntity horseEntity = this.horseRepository.findByName("name1").get();
        assertEquals(25, horseEntity.getAge());
        assertEquals(LocalDate.of(2001, 1, 1), horseEntity.getBirthDate());
        assertEquals("race1", horseEntity.getRace());
        assertEquals(5.0, horseEntity.getHealth());
        assertEquals(new BigDecimal("11000.0"), horseEntity.getPurchasePrice());
        assertEquals(false, horseEntity.getSold());
        assertTrue(horseEntity.getKeeperEntities().stream()
                .map(KeeperEntity::getName)
                .toList()
                .containsAll(Arrays.asList("Keeper1", "Keeper2")));
    }
}
