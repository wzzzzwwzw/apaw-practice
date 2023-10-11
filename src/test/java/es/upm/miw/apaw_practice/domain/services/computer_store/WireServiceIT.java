package es.upm.miw.apaw_practice.domain.services.computer_store;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class WireServiceIT {
    private static final String NOT_EXIST_NAME = "NotExistsTestName";
    @Autowired
    private WireService wireService;

    @Test
    void testReadService() {
        Wire wire = this.wireService.read("DisplayPort");
        assertNotNull(wire);
        assertEquals(new BigDecimal("3.5"), wire.getLength());
        assertEquals("Nylon", wire.getJacketMaterial());
    }

    @Test
    void testCreateWire() {
        Wire wire = this.wireService.create(new Wire(NOT_EXIST_NAME, BigDecimal.ONE, "Plastic"));
        assertNotNull(wire);
        assertEquals(NOT_EXIST_NAME, wire.getName());
        assertEquals(BigDecimal.ONE, wire.getLength());
        assertEquals("Plastic", wire.getJacketMaterial());
    }

    @Test
    void testCreateAlreadyExistsWire() {
        Wire wire = new Wire("HDMI", BigDecimal.ONE, "Plastic");
        assertThrows(ConflictException.class, () -> this.wireService.create(wire));
    }
}
