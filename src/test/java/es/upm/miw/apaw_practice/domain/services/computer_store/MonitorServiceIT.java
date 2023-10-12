package es.upm.miw.apaw_practice.domain.services.computer_store;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.ComputerStoreSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class MonitorServiceIT {
    @Autowired
    private MonitorService monitorService;
    @Autowired
    private ComputerStoreSeederService computerStoreSeederService;

    @AfterEach
    void resetDataBase() {
        this.computerStoreSeederService.deleteAll();
        this.computerStoreSeederService.seedDatabase();
    }

    @Test
    void testUpdateRefreshRate() {
        Monitor monitor = this.monitorService.updateRefreshRate("XIAOMIC34001", 240);
        assertEquals(new BigDecimal("34"), monitor.getSize());
        assertEquals(240, monitor.getRefreshRate());
        assertEquals(3, monitor.getWires().size());
        this.monitorService.updateRefreshRate("XIAOMIC34001", 165);
    }

    @Test
    void testSearchSerialNumberByDateAndCost() {
        List<String> serialNumberList = this.monitorService.findSerialNumberByDateAndCost(LocalDateTime.now(), BigDecimal.ONE);
        assertEquals(2, serialNumberList.size());
    }

    @Test
    void testExceptionSearchSerialNumberByDateAndCost() {
        LocalDateTime threeDaysBeforeNow = LocalDateTime.now().minusDays(3);
        assertThrows(NotFoundException.class, () -> this.monitorService.findSerialNumberByDateAndCost(threeDaysBeforeNow, BigDecimal.ZERO));
    }
}
