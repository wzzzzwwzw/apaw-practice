package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.VaccinePersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class VaccinePesistenceMongodbIT {
    @Autowired
    private VaccinePersistence vaccinePersistence;

    @Test
    void testFindByIdentifierBatch() {

        assertEquals("202301A-FLU-CANIS", vaccinePersistence.findByIdentifierBatch("202301A-FLU-CANIS").getIdentifierBatch());
    }
}
