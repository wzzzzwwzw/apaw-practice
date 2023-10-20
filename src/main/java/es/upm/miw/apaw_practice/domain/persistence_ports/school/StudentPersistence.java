package es.upm.miw.apaw_practice.domain.persistence_ports.school;

import es.upm.miw.apaw_practice.domain.models.school.Student;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface StudentPersistence {

    Stream<Student> readAll();

    Student update(Student student);

    Student readByName(String name);
}
