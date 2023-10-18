package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class PavilionPersistenceMongodbIT {

    @Autowired
    private PavilionPersistenceMongodb pavilionPersistenceMongodb;

    @Test
    void testReadByPavname() {
        Pavilion pavilion = this.pavilionPersistenceMongodb.readByPavname("pavilion1");
        assertEquals("pavilion1", pavilion.getPavname());
        assertEquals("direction1", pavilion.getDirection());

        assertThrows(NotFoundException.class, () -> pavilionPersistenceMongodb.readByPavname("Non-Existent Pavilion"));
    }
}
