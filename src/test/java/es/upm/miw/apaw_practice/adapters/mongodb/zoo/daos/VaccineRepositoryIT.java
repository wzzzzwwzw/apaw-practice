package es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.VaccineEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class VaccineRepositoryIT {
    @Autowired
    private VaccineRepository vaccineRepository;

    @Test
    void testFindByIdentifierBatch() {
        assertTrue(this.vaccineRepository.findByIdentifierBatch("202002C-FLU-FELINAE").isPresent());
        VaccineEntity vaccine = this.vaccineRepository.findByIdentifierBatch("202002C-FLU-FELINAE").get();
        assertEquals("202002C-FLU-FELINAE", vaccine.getIdentifierBatch());
        assertEquals("Felinae General 2020", vaccine.getName());
        assertEquals(LocalDate.of(2020, 7, 9), vaccine.getManufacturingDate());
    }
}
