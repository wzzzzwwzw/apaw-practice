package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.EngineManufacturerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class EngineManufacturerIT {

    @Autowired
    private EngineManufacturerRepository engineManufacturerRepository;

    @Test
    void testFindByManufacturerName() {
        assertTrue(this.engineManufacturerRepository.findByManufacturerName("Honda").isPresent());
        EngineManufacturerEntity engineManufacturer = this.engineManufacturerRepository.findByManufacturerName("Honda").get();

        assertEquals("Honda", engineManufacturer.getManufacturerName());
        assertEquals("Japan", engineManufacturer.getEngineBuiltIn());
        assertEquals(6, engineManufacturer.getNumberOfEnginesSupplied());
    }
}
