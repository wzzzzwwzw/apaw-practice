package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.MonitorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class MonitorRepositoryIT {
    private static final String XIAOMI_SERIAL_NUMBER = "XIAOMIC34001";
    @Autowired
    private MonitorRepository monitorRepository;

    @Test
    void testFindBySerialNumber() {
        assertTrue(this.monitorRepository.findBySerialNumber(XIAOMI_SERIAL_NUMBER).isPresent());
        MonitorEntity monitor = this.monitorRepository.findBySerialNumber(XIAOMI_SERIAL_NUMBER).get();
        assertEquals(165, monitor.getRefreshRate());
        assertEquals(new BigDecimal("34"), monitor.getSize());
        assertEquals(3, monitor.getWireEntities().size());
        this.assertMonitorWires(monitor, "HDMI");
        this.assertMonitorWires(monitor, "Power");
        this.assertMonitorWires(monitor, "DisplayPort");
    }

    private void assertMonitorWires(MonitorEntity monitor, String wireName) {
        assertTrue(monitor.getWireEntities()
                .stream()
                .anyMatch(wire ->
                        wire.getName().equals(wireName)
                )
        );
    }
}
