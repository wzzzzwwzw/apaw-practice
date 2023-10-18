package es.upm.miw.apaw_practice.adapters.mongodb.climbing.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.climbing.Climber;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestConfig
class ClimberPersistenceMongodbIT {

    @Autowired
    private ClimberPersistenceMongodb climberPersistence;

    @Test
    void testReadByEmail() {
        Climber climber = this.climberPersistence.readByEmail("climber1@email.com");
        assertEquals("climber1@email.com", climber.getEmail());
        assertEquals(LocalDate.of(1990, 1, 1), climber.getDateOfBirth());
        assertEquals("Beginner", climber.getLevel());
        assertEquals(2, climber.getExpeditions().size());
        Expedition expedition = climber.getExpeditions().get(0);
        assertEquals(LocalDate.now(), expedition.getDate());
        assertEquals(0, new BigDecimal("1500.00").compareTo(expedition.getTotalExpense()));
    }

    @Test
    void testFindByLevel () {
        List<Climber> climbers = this.climberPersistence.findByLevel("Beginner");
        assertEquals(1, climbers.size());
        assertEquals("Beginner", climbers.get(0).getLevel());
        assertEquals("climber1@email.com", climbers.get(0).getEmail());
        assertEquals(LocalDate.of(1990, 1, 1), climbers.get(0).getDateOfBirth());
        assertEquals(2, climbers.get(0).getExpeditions().size());
        assertEquals(LocalDate.now(), climbers.get(0).getExpeditions().get(0).getDate());
        assertEquals(0, new BigDecimal("1500.00").compareTo(climbers.get(0).getExpeditions().get(0).getTotalExpense()));
        climbers = this.climberPersistence.findByLevel("Medium");
        assertEquals(0, climbers.size());
    }
}
