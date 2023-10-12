package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.ComputerStoreSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class MonitorPersistenceMongodbIT {
    private static final String XIAOMI_SERIAL_NUMBER = "XIAOMIC34001";
    @Autowired
    private MonitorPersistenceMongodb monitorPersistenceMongodb;
    @Autowired
    private ComputerStoreSeederService computerStoreSeederService;

    @AfterEach
    void resetDataBase() {
        this.computerStoreSeederService.deleteAll();
        this.computerStoreSeederService.seedDatabase();
    }

    @Test
    void testReadBySerialNumber() {
        Monitor monitor = this.monitorPersistenceMongodb.readBySerialNumber(XIAOMI_SERIAL_NUMBER);
        assertEquals(new BigDecimal("34"), monitor.getSize());
        assertEquals(165, monitor.getRefreshRate());
        assertEquals(3, monitor.getWires().size());
    }

    @Test
    void testReadBySerialNumberNotFount() {
        assertThrows(NotFoundException.class, () -> this.monitorPersistenceMongodb.readBySerialNumber("hola"));
    }

    @Test
    void testUpdateRefreshRate() {
        Monitor monitor = this.monitorPersistenceMongodb.readBySerialNumber(XIAOMI_SERIAL_NUMBER);
        monitor.setRefreshRate(123);
        this.monitorPersistenceMongodb.updateRefreshRate(monitor);
        monitor = this.monitorPersistenceMongodb.readBySerialNumber(XIAOMI_SERIAL_NUMBER);
        assertEquals(123, monitor.getRefreshRate());
    }

    @Test
    void testUpdateRefreshRateNotFount() {
        Monitor monitor = new Monitor
                .Builder()
                .serialNumber("hola")
                .refreshRate(1)
                .size(BigDecimal.ONE)
                .wires(new ArrayList<>())
                .build();
        assertThrows(NotFoundException.class, () -> this.monitorPersistenceMongodb.updateRefreshRate(monitor));
    }
}
