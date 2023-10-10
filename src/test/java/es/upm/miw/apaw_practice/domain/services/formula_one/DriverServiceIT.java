package es.upm.miw.apaw_practice.domain.services.formula_one;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class DriverServiceIT {

    private DriverService driverService;

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @Test
    void testUpdatePoints() {
        Driver driver = this.driverService.updatePoints(63, 10.0F);
        assertEquals("George Russell", driver.getDriverName());
        assertEquals(63, driver.getNumber());
        assertEquals("United Kingdom", driver.getNationality());
        assertEquals(10.0F, driver.getPoints());
    }

    @Test
    void testUpdatePointsNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.driverService.updatePoints(0, 20.0F);
        });
        assertTrue(exception.getMessage().contains("Driver with number: 0"));
    }
}
