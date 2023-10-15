package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class PatientPersistenceMongodbIT {
    @Autowired
    private PatientPersistenceMongodb patientPersistence;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.patientPersistence.read(".."));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.patientPersistence.read("000000000"));
    }
}

