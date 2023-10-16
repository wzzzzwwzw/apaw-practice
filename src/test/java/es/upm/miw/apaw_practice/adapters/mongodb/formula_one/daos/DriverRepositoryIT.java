package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.DriverEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DriverRepositoryIT {

    @Autowired
    private DriverRepository driverRepository;

    @Test
    void testFindByNumber() {
        assertTrue(this.driverRepository.findByNumber(1).isPresent());
        DriverEntity driver = this.driverRepository.findByNumber(1).get();

        assertEquals(1, driver.getNumber());
        assertEquals("Max Verstappen", driver.getDriverName());
        assertEquals("Netherlands", driver.getNationality());
        assertEquals(224.5F, driver.getPoints());
    }

    @Test
    void testFindByNumberNotFound() {
        assertTrue(this.driverRepository.findByNumber(0).isEmpty());
    }
}
