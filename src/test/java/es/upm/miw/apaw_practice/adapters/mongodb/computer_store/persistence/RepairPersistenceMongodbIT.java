package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.ComputerStoreSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Repair;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class RepairPersistenceMongodbIT {
    @Autowired
    private RepairPersistenceMongodb repairPersistenceMongodb;
    @Autowired
    private ComputerStoreSeederService computerStoreSeederService;

    @AfterEach
    void resetDatabase() {
        this.computerStoreSeederService.deleteAll();
        this.computerStoreSeederService.seedDatabase();
    }

    @Test
    void testUpdateRepairEndTime() {
        Repair repair = this.repairPersistenceMongodb.updateEndTimeByRepairNumber("1234");
        assertNotNull(repair);
        assertEquals("1234", repair.getRepairNumber());
        assertTrue(repair.getBeginTime().toLocalDate().atStartOfDay().isEqual(LocalDate.now().atStartOfDay()));
        assertTrue(repair.getEndTime().toLocalDate().atStartOfDay().isEqual(LocalDate.now().atStartOfDay()));
    }

    @Test
    void testUpdateRepairTimeException() {
        assertThrows(NotFoundException.class, () -> this.repairPersistenceMongodb.updateEndTimeByRepairNumber("test"));
    }
}
