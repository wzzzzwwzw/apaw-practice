package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class WirePersistenceMongodbIT {
    @Autowired
    private WirePersistenceMongodb wirePersistence;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.wirePersistence.read(".."));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.wirePersistence.read("HDMI"));
    }

    @Test
    void testCreateWire() {
        Wire wire = this.wirePersistence.create(new Wire("TestWire", BigDecimal.ONE, "Plastic"));
        Wire createdWire = this.wirePersistence.create(wire);
        assertNotNull(createdWire);
        assertEquals(wire.getName(), createdWire.getName());
        assertEquals(wire.getLength(), createdWire.getLength());
        assertEquals(wire.getJacketMaterial(), createdWire.getJacketMaterial());
    }

    @Test
    void testExistWireName() {
        assertTrue(this.wirePersistence.existsWireName("HDMI"));
    }

    @Test
    void testNotExistWireName() {
        assertFalse(this.wirePersistence.existsWireName("wirewire"));
    }
}

