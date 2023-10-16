package es.upm.miw.apaw_practice.domain.persistence_ports.school;

import es.upm.miw.apaw_practice.domain.models.school.Student;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface StudentPersistence {

    Stream<Student> readAll();

    Student create(Student student);

    Student update(Student student);

    Student read(String name);

    Student readByName(String name);

    boolean existName(String name);
}
