package es.upm.miw.apaw_practice.adapters.mongodb.stable.daos;

import es.upm.miw.apaw_practice.TestConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class StableRepositoryIT {
    @Autowired
    private StableRepository stableRepository;
    @Test
    void testCreateAndRead() {

        assertTrue(this.stableRepository.findAll().stream()
                .anyMatch(stable ->
                        "StableName1".equals(stable.getName()) &&
                        "StableAddress1".equals(stable.getAddress()) &&
                        50 == stable.getMaxCapacity() &&
                        LocalDate.of(1999, 1, 1).equals(stable.getFoundationDate()) &&
                        "name1".equals(stable.getHorseEntities().get(0).getName()) &&
                        new BigDecimal("11000.0").equals(stable.getHorseEntities().get(0).getPurchasePrice())
                ));
    }
}
