package es.upm.miw.apaw_practice.adapters.mongodb.school.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.school.SchoolSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.SchoolEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.StudentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.SubjectEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class SchoolRepositoryIT {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SchoolSeederService schoolSeederService;

    @AfterEach
    void resetDataBase() {
        this.schoolSeederService.deleteAll();
        this.schoolSeederService.seedDatabase();
    }

    @Test
    void testRead() {
        assertTrue(this.schoolRepository.findByName("school1").isPresent());
        SchoolEntity school1 = this.schoolRepository.findByName("school1").get();
        assertEquals("address1", school1.getAddress());
        assertEquals(LocalDate.of(2001, 3, 5), school1.getOpeningDate());
        assertEquals(new BigDecimal("3000.00"), school1.getRegistrationPrice());

        assertTrue(this.schoolRepository.findByName("school2").isPresent());
        SchoolEntity school2 = this.schoolRepository.findByName("school2").get();
        assertNotEquals(school1, school2);

        assertEquals(List.of("student1", "student2"), school1.getStudents().stream()
                .map(StudentEntity::getName)
                .toList()
                );

        assertEquals(List.of("subject1", "subject2"), school1.getStudents().stream()
                .flatMap(studentEntity -> studentEntity.getSubjectsEntities().stream())
                .map(SubjectEntity::getTitle)
                .toList()
        );
    }
}
