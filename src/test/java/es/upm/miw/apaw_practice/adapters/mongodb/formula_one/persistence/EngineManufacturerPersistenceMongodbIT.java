package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.formula_one.EngineManufacturer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class EngineManufacturerPersistenceMongodbIT {

    @Autowired
    private EngineManufacturerPersistenceMongodb engineManufacturerPersistenceMongodb;

    @Test
    void testCreate() {
        EngineManufacturer engineManufacturer =
                this.engineManufacturerPersistenceMongodb.create(new EngineManufacturer("Ferrari", "Italy", 12));
        assertEquals("Ferrari", engineManufacturer.getManufacturerName());
        assertEquals("Italy", engineManufacturer.getEngineBuiltIn());
        assertEquals(12, engineManufacturer.getNumberOfEnginesSupplied());
    }

    @Test
    void testExistEngineManufacturer() {
        assertTrue(this.engineManufacturerPersistenceMongodb.existEngineManufacturer("Honda"));
        assertFalse(this.engineManufacturerPersistenceMongodb.existEngineManufacturer("Audi"));
    }

    @Test
    void testFindManufacturersNamesByHostCountry() {
        assertEquals(List.of("Honda"),
                this.engineManufacturerPersistenceMongodb.findManufacturersNamesByHostCountry("Austria").toList());
    }

    @Test
    void testNotFindManufacturersNamesByHostCountry() {
        assertTrue(this.engineManufacturerPersistenceMongodb.findManufacturersNamesByHostCountry("Nigeria").toList().isEmpty());
    }
}
