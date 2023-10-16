package es.upm.miw.apaw_practice.adapters.mongodb.climbing.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.ClimbingSeederService;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

@TestConfig
class ExpeditionPersistenceMongodbIT {
    @Autowired
    private ExpeditionPersistenceMongodb expeditionPersistenceMongodb;
    @Autowired
    private ClimbingSeederService climbingSeederService;

    @AfterEach
    void resetDataBase() {
        this.climbingSeederService.deleteAll();
        this.climbingSeederService.seedDatabase();
    }

    @Test
    void testCreateExpedition() {
        Expedition expedition = new Expedition(LocalDate.now(), new BigDecimal("1500.00"));
        Expedition expeditionBD = this.expeditionPersistenceMongodb.create(expedition);
        assertEquals(LocalDate.now(), expeditionBD.getDate());
        assertEquals(0, new BigDecimal("1500.00").compareTo(expeditionBD.getTotalExpense()));
    }

    @Test
    void testReadByIdentifier() {
        Expedition expedition = this.expeditionPersistenceMongodb.readByIdentifier("1");
        assertEquals("1", expedition.getIdentifier());
        assertEquals(LocalDate.now(), expedition.getDate());
        assertEquals(0, new BigDecimal("1500.00").compareTo(expedition.getTotalExpense()));
    }

    @Test
    void testUpdate() {
        Expedition expedition = new Expedition("1", LocalDate.now(), new BigDecimal("2000.00"));
        Expedition expeditionBD = this.expeditionPersistenceMongodb.update(expedition);
        assertEquals("1", expeditionBD.getIdentifier());
        assertEquals(LocalDate.now(), expeditionBD.getDate());
        assertEquals(0, new BigDecimal("2000.00").compareTo(expeditionBD.getTotalExpense()));
    }
}
