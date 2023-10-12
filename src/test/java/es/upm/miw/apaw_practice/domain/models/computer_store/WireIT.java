package es.upm.miw.apaw_practice.domain.models.computer_store;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WireIT {
    @Test
    void testWireBuilder() {
        Wire wire = new Wire.Builder()
                .name("wwww")
                .length(BigDecimal.ONE)
                .jacketMaterial("Plastic")
                .build();
        assertNotNull(wire);
        assertEquals("wwww", wire.getName());
        assertEquals(BigDecimal.ONE, wire.getLength());
        assertEquals("Plastic", wire.getJacketMaterial());
    }
}
