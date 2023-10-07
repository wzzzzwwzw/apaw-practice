package es.upm.miw.apaw_practice.domain.services.computer_store;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class MonitorServiceIT {
    @Autowired
    private MonitorService monitorService;

    @Test
    void testUpdateRefreshRate() {
        Monitor monitor = this.monitorService.updateRefreshRate("XIAOMIC34001", 240);
        assertEquals(new BigDecimal("34"), monitor.getSize());
        assertEquals(240, monitor.getRefreshRate());
        assertEquals(3, monitor.getWires().size());
    }
}
