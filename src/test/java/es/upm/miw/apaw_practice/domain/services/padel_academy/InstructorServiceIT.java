package es.upm.miw.apaw_practice.domain.services.padel_academy;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.PadelAcademySeederService;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Instructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class InstructorServiceIT {
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private PadelAcademySeederService padelAcademySeederService;

    @AfterEach
    void resetDatabase() {
        this.padelAcademySeederService.deleteAll();
        this.padelAcademySeederService.seedDatabase();
    }

    @Test
    void testUpdate(){
        String dni =  "13579086B";
        Integer phoneNumber = 123456789;
        Instructor instructor = instructorService.updatePhoneNumber(dni, phoneNumber);
        assertNotNull(instructor);
        assertEquals(phoneNumber, instructor.getPhoneNumber());
    }
}
