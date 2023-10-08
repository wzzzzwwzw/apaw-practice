package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class VaccinePesistenceMongodbIT {
    @Autowired
    private VaccinePersistenceMongodb vaccinePersistence;

    @Test
    void testFindByIdentifierBatch() {

        assertEquals("202301A-FLU-CANIS", this.vaccinePersistence.findByIdentifierBatch("202301A-FLU-CANIS").getIdentifierBatch());
    }
}
