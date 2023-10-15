package es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ExpeditionRepositoryIT {

    @Autowired
    private ExpeditionRepository expeditionRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.expeditionRepository.findAll().stream()
                .anyMatch(expedition ->
                        LocalDate.now().equals(expedition.getDate()) &&
                                0 == new BigDecimal("1500.00").compareTo(expedition.getTotalExpense())
                ));
    }
}
