package es.upm.miw.apaw_practice.domain.services.climbing;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.ClimbingSeederService;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.ExpeditionPersistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class ExpeditionServiceIT {

    @Autowired
    private ExpeditionService expeditionService;
    @Autowired
    private ExpeditionPersistence expeditionPersistence;
    @Autowired
    private ClimbingSeederService climbingSeederService;

    @AfterEach
    void resetDataBase() {
        this.climbingSeederService.deleteAll();
        this.climbingSeederService.seedDatabase();
    }

    @Test
    void testUpdateTotalExpense() {
        this.expeditionService.updateTotalExpense("1",  new BigDecimal("2000.00"));
        Expedition expedition = this.expeditionPersistence.readByIdentifier("1");
        assertEquals("1", expedition.getIdentifier());
        assertEquals(LocalDate.now(), expedition.getDate());
        assertEquals(0, new BigDecimal("2000.00").compareTo(expedition.getTotalExpense()));
    }

    @Test
    void testFindSumOfTotalExpenseByRouteDifficulty() {
        assertEquals(0, new BigDecimal("2000.00").compareTo(this.expeditionService.findSumOfTotalExpenseByRouteDifficulty("Easy")));
        assertEquals(0, new BigDecimal("3500.00").compareTo(this.expeditionService.findSumOfTotalExpenseByRouteDifficulty("Medium")));
        assertEquals(0, new BigDecimal("2500.00").compareTo(this.expeditionService.findSumOfTotalExpenseByRouteDifficulty("Hard")));
    }
}
