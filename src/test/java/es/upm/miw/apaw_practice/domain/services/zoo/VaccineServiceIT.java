package es.upm.miw.apaw_practice.domain.services.zoo;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.Vaccine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class VaccineServiceIT {
    @Autowired
    private VaccineService vaccineService;

    @Test
    void testFindByIdentifierBatchService() {
        Vaccine vaccine = vaccineService.findByIdentifierBatch("202301A-FLU-FELIS");
        assertNotNull(vaccine);
        assertEquals("202301A-FLU-FELIS", vaccine.getIdentifierBatch());
        assertEquals("Felis Flu 2023", vaccine.getName());
        assertEquals(LocalDate.of(2023, 1, 20), vaccine.getManufacturingDate());
    }
}
