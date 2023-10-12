package es.upm.miw.apaw_practice.adapters.mongodb.school.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class StudentRepositoryIT {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.studentRepository.findByName("student1").isPresent());
        StudentEntity student1 = this.studentRepository.findByName("student1").get();
        assertEquals(20, student1.getAge());
        assertEquals("student1@mail.test", student1.getEmail());
        assertEquals(612345678, student1.getContact());

        assertTrue(this.studentRepository.findByName("student2").isPresent());
        StudentEntity student2 = this.studentRepository.findByName("student2").get();
        assertNotEquals(student1, student2);

        assertTrue(this.studentRepository.findAll().stream()
            .anyMatch(student ->
                "student1".equals(student.getName()) &&
                    student1.getId() != null &&
                    student1.getAge() == 20 &&
                    student1.getEmail().equals("student1@mail.test") &&
                    student1.getContact() == 612345678 &&
                    student1.getClassroom().getLocation().equals("classroom1") &&
                    student1.getSubjectsEntities().size() == 2 &&
                    "subject1".equals(student1.getSubjectsEntities().get(0).getTitle())
            ));
    }
}
