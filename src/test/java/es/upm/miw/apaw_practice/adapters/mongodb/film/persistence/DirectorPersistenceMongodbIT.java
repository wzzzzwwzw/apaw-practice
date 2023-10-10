package es.upm.miw.apaw_practice.adapters.mongodb.film.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.film.Director;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestConfig
class DirectorPersistenceMongodbIT {

    @Autowired
    private DirectorPersistenceMongodb directorPersistenceMongodb;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.directorPersistenceMongodb.read("0"));
    }

    @Test
    void testExistDirectorDni() {
        assertTrue(this.directorPersistenceMongodb.existsDirectorDni("05645800X"));
    }

    @Test
    void testNotExistDirectorDni() {
        assertFalse(this.directorPersistenceMongodb.existsDirectorDni("0"));
    }

    @Test
    void testCreateAndRead() {
        Director director = this.directorPersistenceMongodb.create(
                new Director("35469251P", "Luis", "Garcia", LocalDate.of(1999, 5, 29))
        );
        Director directorBD = this.directorPersistenceMongodb.read("35469251P");
        assertEquals("Luis", directorBD.getName());
        assertEquals("Garcia", directorBD.getSurname());
        assertEquals(LocalDate.of(1999, 5, 29), directorBD.getDateOfBirth());
    }
}
