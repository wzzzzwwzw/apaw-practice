package es.upm.miw.apaw_practice.adapters.mongodb.climbing.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class AreaPersistenceMongodbIT {

    @Autowired
    private AreaPersistenceMongodb areaPersistenceMongodb;

    @Test
    void testReadByName() {
        Area area = this.areaPersistenceMongodb.readByName("Area 1");
        assertEquals("Area 1", area.getName());
        assertEquals("Location 1", area.getLocation());
        assertTrue(area.getEasyAccess());
        assertEquals(2, area.getRoutes().size());
        assertEquals("Route 1", area.getRoutes().get(0).getName());
        assertEquals("Route 2", area.getRoutes().get(1).getName());
        Expedition expedition = area.getExpedition();
        assertEquals(LocalDate.now(), expedition.getDate());
        assertEquals(0, new BigDecimal("1500.00").compareTo(expedition.getTotalExpense()));
    }
}
