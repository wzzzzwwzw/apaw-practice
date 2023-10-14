package es.upm.miw.apaw_practice.domain.persistence_ports.school;

import es.upm.miw.apaw_practice.domain.models.school.Classroom;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ClassroomPersistence {

    Stream<Classroom> readAll();

    Classroom create(Classroom classroom);

    Classroom update(String location, Classroom classroom);

    Classroom read(String location);

    boolean existLocation(String location);
}
