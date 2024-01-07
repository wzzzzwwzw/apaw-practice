package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities.InstructorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class InstructorRepositoryIT {

    @Autowired
    InstructorRepository instructorRepository;

    @Test
    void testFindByDNI() {
        assertTrue(this.instructorRepository.findByDni("12345678A").isPresent());
        InstructorEntity instructor = this.instructorRepository.findByDni("12345678A").get();
        assertEquals("Ana", instructor.getName());
        assertEquals(654456545, instructor.getPhoneNumber());
    }
}
