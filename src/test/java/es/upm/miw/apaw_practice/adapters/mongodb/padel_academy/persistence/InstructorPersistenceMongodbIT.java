package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.PadelAcademySeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Instructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class InstructorPersistenceMongodbIT {
    @Autowired
    private InstructorPersistenceMongodb instructorPersistenceMongodb;
    @Autowired
    private PadelAcademySeederService padelAcademySeederService;

    @AfterEach
    void resetDatabase() {
        this.padelAcademySeederService.deleteAll();
        this.padelAcademySeederService.seedDatabase();
    }

    @Test
    void testReadByDni() {
        Instructor instructor = this.instructorPersistenceMongodb.read("13579086B");
        assertEquals("Pedro", instructor.getName());
        assertEquals(678787667, instructor.getPhoneNumber());
        assertEquals("13579086B", instructor.getDni());
    }

    @Test
    void testReadNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.instructorPersistenceMongodb.read("123455");
        });
        assertTrue(exception.getMessage().contains("Instructor with dni 123455 not found."));
    }

    @Test
    void testUpdate(){
        Instructor instructor = this.instructorPersistenceMongodb.read("12345678A");
        instructor.setPhoneNumber(123456789);
        Instructor instructorUpdated = this.instructorPersistenceMongodb.update(instructor);
        assertEquals("12345678A" ,instructorUpdated.getDni());
        assertEquals(123456789, instructorUpdated.getPhoneNumber());
    }
}
