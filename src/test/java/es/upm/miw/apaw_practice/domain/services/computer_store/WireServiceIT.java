package es.upm.miw.apaw_practice.domain.services.computer_store;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class WireServiceIT {
    @Autowired
    private WireService wireService;

    @Test
    void testReadService() {
        Wire wire = this.wireService.read("DisplayPort");
        assertNotNull(wire);
        assertEquals(new BigDecimal("3.5"), wire.getLength());
        assertEquals("Nylon", wire.getJacketMaterial());
    }
}
