package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.school.SchoolSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.StudentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.StudentEntity;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class StudentPersistenceMongodbIT {

    @Autowired
    private StudentPersistenceMongodb studentPersistence;

    @Autowired
    private SchoolSeederService schoolSeederService;

    @Test
    void testReadByName() {
        Student student = this.studentPersistence.readByName("student1");
        assertEquals(20, student.getAge());
        assertEquals(612345678, student.getContact());
        assertEquals("student1@mail.test", student.getEmail());
        assertEquals("classroom1", student.getClassroom().getLocation());
        assertTrue(student.getSubjects().stream()
                .map(Subject::getTitle)
                .toList()
                .containsAll(List.of("subject1", "subject2")));
    }

    @Test
    void testReadAll() {
        List<Student> students = this.studentPersistence.readAll().toList();

        assertEquals(9, students.size());
        assertEquals("student4", students.get(3).getName());
        assertEquals(20, students.get(0).getAge());
        assertEquals("classroom5", students.get(4).getClassroom().getLocation());
        assertTrue(students.subList(6, 8).stream().flatMap(student -> student.getSubjects().stream())
                .map(Subject::getTitle)
                .distinct()
                .toList()
                .containsAll(List.of("subjectS1", "subjectS2", "subjectS3")));
    }

    @Test
    void testUpdate() {
        Student student = studentPersistence.readByName("studentS2");
        Student student1 = studentPersistence.readByName("studentS3");
        student.setSubjects(student1.getSubjects());
        this.studentPersistence.update(student);
        Student updatedStudent = studentPersistence.readByName("studentS3");
        assertEquals("studentS3", updatedStudent.getName());
        assertEquals(student1.getSubjects(), updatedStudent.getSubjects());

        schoolSeederService.deleteAll();
        schoolSeederService.seedDatabase();
    }
}
