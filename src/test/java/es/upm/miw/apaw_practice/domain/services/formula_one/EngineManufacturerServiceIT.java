package es.upm.miw.apaw_practice.domain.services.formula_one;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.formula_one.EngineManufacturer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class EngineManufacturerServiceIT {

    @Autowired
    private EngineManufacturerService engineManufacturerService;

    @Test
    void testCreate() {
        EngineManufacturer engineManufacturer =
                this.engineManufacturerService.create(new EngineManufacturer("Ford", "USA", 0));
        assertEquals("Ford", engineManufacturer.getManufacturerName());
        assertEquals("USA", engineManufacturer.getEngineBuiltIn());
        assertEquals(0, engineManufacturer.getNumberOfEnginesSupplied());
    }

    @Test
    void testAssertEngineManufacturerNotExist() {
        EngineManufacturer engineManufacturer = new EngineManufacturer("Honda", "Japan", 6);
        RuntimeException exception = assertThrows(ConflictException.class, () -> {
            this.engineManufacturerService.create(engineManufacturer);
        });
        assertTrue(exception.getMessage().contains("Engine manufacturer exist: Honda"));
    }

    @Test
    void testFindManufacturersNamesByHostCountry() {
        assertEquals(List.of("Honda", "Mercedes"),
                this.engineManufacturerService.findManufacturersNamesByHostCountry("Australia").toList());
    }

    @Test
    void testNotFindManufacturersNamesByHostCountry() {
        assertTrue(this.engineManufacturerService.findManufacturersNamesByHostCountry("Argentina").toList().isEmpty());
    }
}
