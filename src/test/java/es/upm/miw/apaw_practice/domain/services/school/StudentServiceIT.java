package es.upm.miw.apaw_practice.domain.services.school;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.school.SchoolSeederService;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class StudentServiceIT {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolSeederService schoolSeederService;

    @AfterEach
    void resetDataBase() {
        this.schoolSeederService.deleteAll();
        this.schoolSeederService.seedDatabase();
    }

    @Test
    void testUpdateSubjects() {
        List<Subject> subjects = List.of(new Subject("subject5", "desc5", true, 16),
                new Subject("subject6", "desc6", false, 1));

        List<Subject> newsubjects = this.studentService.updateSubjects("student4", subjects).getSubjects();

        assertEquals(subjects.get(0), newsubjects.get(0));
        assertEquals(subjects.get(1), newsubjects.get(1));
    }
}
