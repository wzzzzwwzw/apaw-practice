package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.ClassroomRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.ClassroomEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.school.Classroom;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.ClassroomPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("ClassroomPersistence")

public class ClassroomPersistenceMongodb implements ClassroomPersistence {
    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomPersistenceMongodb(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Classroom read(String location) {
        return this.classroomRepository
                .findByLocation(location)
                .orElseThrow(() -> new NotFoundException("Classroom location: " + location))
                .toClassroom();
    }

    @Override
    public boolean existLocation(String location) {
        return this.classroomRepository
                .findByLocation(location)
                .isPresent();
    }

    @Override
    public Stream<Classroom> readAll() {
        return this.classroomRepository
                .findAll().stream()
                .map(ClassroomEntity::toClassroom);
    }

    @Override
    public Classroom create(Classroom classroom) {
        return this.classroomRepository
                .save(new ClassroomEntity(classroom))
                .toClassroom();
    }

    @Override
    public Classroom update(String location, Classroom classroom) {
        ClassroomEntity classroomEntity = this.classroomRepository
                .findByLocation(classroom.getLocation())
                .orElseThrow(() -> new NotFoundException("Classroom location: " + classroom.getLocation()));
        classroomEntity.fromClassroom(classroom);
        return this.classroomRepository
                .save(classroomEntity)
                .toClassroom();
    }
}
