package es.upm.miw.apaw_practice.domain.services.school;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.school.Classroom;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.ClassroomPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ClassroomService {

    private final ClassroomPersistence classroomPersistence;

    @Autowired
    public ClassroomService(ClassroomPersistence classroomPersistence) {
        this.classroomPersistence = classroomPersistence;
    }

    public void assertLocationNotExist(String location) {
        if (this.classroomPersistence.existLocation(location)) {
            throw new ConflictException("Location exist: " + location);
        }
    }

    public Classroom create(Classroom classroom) {
        this.assertLocationNotExist(classroom.getLocation());
        return this.classroomPersistence.create(classroom);
    }

    public Classroom read(String location) {
        return this.classroomPersistence.read(location);
    }

    public void updateLockers(Stream<Classroom> classrooms) {
        classrooms.map(newClassroom -> {
                    Classroom classroom = this.classroomPersistence.read(newClassroom.getLocation());
                    classroom.setLockers(newClassroom.getLockers());
                    return classroom;
                })
                .forEach(classroom -> this.classroomPersistence.update(classroom.getLocation(), classroom));
    }
}
