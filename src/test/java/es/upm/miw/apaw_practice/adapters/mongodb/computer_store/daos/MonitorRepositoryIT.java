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
    @Autowired
    private MonitorRepository monitorRepository;
    private static final String XIAOMI_SERIAL_NUMBER = "XIAOMIC34001";
    @Test
    void testFindBySerialNumber(){
        assertTrue(monitorRepository.findBySerialNumber(XIAOMI_SERIAL_NUMBER).isPresent());
        MonitorEntity monitor = monitorRepository.findBySerialNumber(XIAOMI_SERIAL_NUMBER).get();
        assertEquals(165,monitor.getRefreshRate());
        assertEquals(new BigDecimal("34"),monitor.getSize());
        assertEquals(3,monitor.getWires().size());
        this.assertMonitorWires(monitor,"HDMI");
        this.assertMonitorWires(monitor,"Power");
        this.assertMonitorWires(monitor,"DisplayPort");
    }
    private void assertMonitorWires(MonitorEntity monitor, String wireName){
        assertTrue(monitor.getWires()
                .stream()
                .anyMatch(wire->
                        wire.getName().equals(wireName)
                )
        );
    }
}
