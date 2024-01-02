package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.WireEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class WireRepositoryIT {
    @Autowired
    private WireRepository wireRepository;
    private static final String HDMI_NAME = "HDMI";

    @Test
    void testFindByName() {
        assertTrue(this.wireRepository.findByName(HDMI_NAME).isPresent());
        WireEntity hdmiWire = wireRepository.findByName(HDMI_NAME).get();
        assertEquals(new BigDecimal("1.5"), hdmiWire.getLength());
        assertEquals("Plastic", hdmiWire.getJacketMaterial());
    }
}
