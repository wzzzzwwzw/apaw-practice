package es.upm.miw.apaw_practice.domain.models.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class StudentIT {

    private final Classroom classroom = new Classroom("c1", LocalDateTime.MIN, true, 4);
    private final Student student = new Student("student1", 20, 612345678, "student1@mail.test", classroom);
    @Test
    void testTreeStudentsComposite() {
        StudentsComposite studentsComposite = new StudentsComposite("Student");
        Assertions.assertTrue(studentsComposite.isComposite());
        studentsComposite.add(this.student);
        Assertions.assertEquals(1, studentsComposite.getTreeStudents().size());

        studentsComposite.remove(this.student);
        Assertions.assertEquals(0, studentsComposite.getTreeStudents().size());
    }

    @Test
    void testTreeStudentLeaf() {
        Assertions.assertFalse(this.student.isComposite());
        Assertions.assertThrows(UnsupportedOperationException.class, () -> this.student.add(student));
    }
}
