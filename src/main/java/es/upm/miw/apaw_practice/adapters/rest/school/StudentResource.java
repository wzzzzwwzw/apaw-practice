package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import es.upm.miw.apaw_practice.domain.services.school.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(StudentResource.STUDENTS)
public class StudentResource {
    static final String STUDENTS = "/school/students";

    static final String NAME_ID = "/{name}";

    static final String SUBJECTS = "/subjects";

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping(NAME_ID + SUBJECTS)
    public Student updateSubjects(@PathVariable String name, @RequestBody List<Subject> subjects) {
        return this.studentService.updateSubjects(name, subjects);
    }
}