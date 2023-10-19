package es.upm.miw.apaw_practice.domain.services.school;

import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.StudentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentPersistence studentPersistence;

    @Autowired
    public StudentService(StudentPersistence studentPersistence) {
        this.studentPersistence = studentPersistence;
    }

    public Student updateSubjects(String name, List<Subject> subjects) {
        Student student = this.studentPersistence.readByName(name);
        student.setSubjects(subjects);
        return this.studentPersistence.update(student);
    }
}
