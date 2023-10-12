package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class DriverPersistenceMongodbIT {

    private final DriverPersistenceMongodb driverPersistenceMongodb;

    @Autowired
    public DriverPersistenceMongodbIT(DriverPersistenceMongodb driverPersistenceMongodb) {
        this.driverPersistenceMongodb = driverPersistenceMongodb;
    }

    @Test
    void testReadByNumber() {
        Driver driver = this.driverPersistenceMongodb.readByNumber(81);
        assertEquals("Oscar Piastri", driver.getDriverName());
        assertEquals("Australia", driver.getNationality());
        assertEquals(81, driver.getNumber());
    }

    @Test
    void testReadByNumberNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.driverPersistenceMongodb.readByNumber(0);
        });
        assertTrue(exception.getMessage().contains("Driver with number: 0"));
    }

    @Test
    void testUpdate() {
        Driver originalDriver = this.driverPersistenceMongodb.readByNumber(4);
        assertNull(originalDriver.getPoints());
        originalDriver.setPoints(154.0F);
        Driver updatedDriver = this.driverPersistenceMongodb.update(originalDriver);
        assertEquals(154.0F, updatedDriver.getPoints());
    }

    @Test
    void testUpdateNotFound() {
        Driver driver = new Driver(6, "Nicholas Latifi", "Canada");
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.driverPersistenceMongodb.update(driver);
        });
        assertTrue(exception.getMessage().contains("Driver with number: 6"));
    }

    @Test
    void testFindTotalPointsByEnginesBuiltIn() {
        Float points = this.driverPersistenceMongodb.findTotalPointsByEnginesBuiltIn("Japan");
        assertEquals(332.5F, points);
    }

    @Test
    void testFindTotalPointsByEnginesBuiltInNotExistEnginesBuiltIn() {
        Float points = this.driverPersistenceMongodb.findTotalPointsByEnginesBuiltIn("Spain");
        assertEquals(0F, points);
    }
}