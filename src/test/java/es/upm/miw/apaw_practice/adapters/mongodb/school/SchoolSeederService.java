package es.upm.miw.apaw_practice.adapters.mongodb.school;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.ClassroomRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.StudentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.SubjectRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.ClassroomEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.StudentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.SubjectEntity;

import es.upm.miw.apaw_practice.domain.models.school.Classroom;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class SchoolSeederService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- School Initial Load -----------");
        SubjectEntity[] subjects = {
                new SubjectEntity(new Subject("subject1", "desc1", true, 6)),
                new SubjectEntity(new Subject("subject2", "desc2", false, 5)),
                new SubjectEntity(new Subject("subject3", "desc3", false, 10)),
                new SubjectEntity(new Subject("subject4", "desc4", false, 1)),
                new SubjectEntity(new Subject("subject5", "desc5", true, 16))
        };
        this.subjectRepository.saveAll(Arrays.asList(subjects));

        ClassroomEntity[] classrooms = {
                new ClassroomEntity(new Classroom("classroom1", LocalDateTime.of(2019, 1, 5, 8, 30), true, 30)),
                new ClassroomEntity(new Classroom("classroom2", LocalDateTime.of(2020, 12, 10, 10, 00), false, 0)),
                new ClassroomEntity(new Classroom("classroom3", LocalDateTime.of(2021, 5, 2, 9, 45), true, 10)),
                new ClassroomEntity(new Classroom("classroom4", LocalDateTime.of(2022, 2, 8, 7, 15), false, 25)),
                new ClassroomEntity(new Classroom("classroom5", LocalDateTime.of(2023, 9, 1, 8, 00), true, 50))
        };
        this.classroomRepository.saveAll(Arrays.asList(classrooms));

        StudentEntity[] students = {
                new StudentEntity("student1", 20, 612345678, "student1@mail.test", classrooms[0], List.of(subjects[0], subjects[1])),
                new StudentEntity("student2", 30, 687654321, "student2@mail.test", classrooms[1], List.of()),
                new StudentEntity("student3", 40, 666666666, "student3@mail.test", classrooms[2], List.of(subjects[2], subjects[3], subjects[4])),
                new StudentEntity("student4", 50, 777777777, "student4@mail.test", classrooms[3], List.of(subjects[1])),
                new StudentEntity("student5", 60, 888888888, "student5@mail.test", classrooms[4], List.of(subjects[1], subjects[2], subjects[3], subjects[4]))
        };
        this.studentRepository.saveAll(Arrays.asList(students));
    }

    public void deleteAll() {
        this.subjectRepository.deleteAll();
    }
}
