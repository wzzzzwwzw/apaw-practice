package es.upm.miw.apaw_practice.domain.models.formula_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DriverIT {

    @Test
    void testDriverBuilder() {
        Driver driver = new Driver.Builder()
                .number(55)
                .driverName("Carlos Sainz")
                .nationality("Spain")
                .points(203.0F)
                .build();
        assertNotNull(driver);
        assertEquals(55, driver.getNumber());
        assertEquals("Carlos Sainz", driver.getDriverName());
        assertEquals("Spain", driver.getNationality());
        assertEquals(203.0F, driver.getPoints());
    }
}
