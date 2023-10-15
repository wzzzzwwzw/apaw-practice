package es.upm.miw.apaw_practice.adapters.mongodb.climbing.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

@TestConfig
public class ExpeditionPersistenceMongodbIT {
    @Autowired
    private ExpeditionPersistenceMongodb expeditionPersistenceMongodb;

    @Test
    void testCreateExpedition() {
        Expedition expedition = new Expedition(LocalDate.now(), new BigDecimal("1500.00"));
        Expedition expeditionBD = this.expeditionPersistenceMongodb.create(expedition);
        assertEquals(LocalDate.now(), expeditionBD.getDate());
        assertEquals(0, new BigDecimal("1500.00").compareTo(expeditionBD.getTotalExpense()));
    }
}
