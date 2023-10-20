package es.upm.miw.apaw_practice.adapters.mongodb.school.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.school.SchoolSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.SubjectEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class SubjectRepositoryIT {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SchoolSeederService schoolSeederService;

    @AfterEach
    void resetDataBase() {
        this.schoolSeederService.deleteAll();
        this.schoolSeederService.seedDatabase();
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.subjectRepository.findByTitle("subject1").isPresent());
        SubjectEntity subject1 = this.subjectRepository.findByTitle("subject1").get();
        assertEquals("desc1", subject1.getDescription());
        assertEquals(6, subject1.getCredits());
        assertTrue(subject1.getBilingual());

        assertTrue(this.subjectRepository.findByTitle("subject2").isPresent());
        SubjectEntity subject2 = this.subjectRepository.findByTitle("subject2").get();
        assertNotEquals(subject1, subject2);
    }
}