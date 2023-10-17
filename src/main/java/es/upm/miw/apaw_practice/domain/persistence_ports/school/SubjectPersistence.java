package es.upm.miw.apaw_practice.domain.persistence_ports.school;

import es.upm.miw.apaw_practice.domain.models.school.Subject;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SubjectPersistence {

    Stream<Subject> readAll();

    Subject create(Subject subject);

    void delete(String title);

    Subject read(String title);

    boolean existTitle(String title);
}
