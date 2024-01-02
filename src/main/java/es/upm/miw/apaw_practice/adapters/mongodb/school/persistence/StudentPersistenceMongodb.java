package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.SubjectRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.SubjectEntity;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.StudentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.StudentEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.StudentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("StudentPersistence")
public class StudentPersistenceMongodb implements StudentPersistence {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public StudentPersistenceMongodb(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Student readByName(String name) {
        return this.studentRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Student name:" + name))
                .toStudent();
    }

    @Override
    public Stream<Student> readAll() {
        return this.studentRepository
                .findAll().stream()
                .map(StudentEntity::toStudent);
    }

    @Override
    public Student update(Student student) {
        StudentEntity studentEntity = this.studentRepository
                .findByName(student.getName())
                .orElseThrow(() -> new NotFoundException("Student name: " + student.getName()));

        studentEntity.setSubjectsEntities(
            student.getSubjects().stream()
                    .map(subject -> this.subjectRepository.findByTitle(subject.getTitle())
                            .orElseGet(() -> {
                                SubjectEntity newSubject = new SubjectEntity(subject);
                                return this.subjectRepository.save(newSubject);
                            })).toList());

        return this.studentRepository
                .save(studentEntity)
                .toStudent();
    }
}
