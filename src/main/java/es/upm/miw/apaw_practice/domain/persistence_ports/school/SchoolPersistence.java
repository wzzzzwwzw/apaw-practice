package es.upm.miw.apaw_practice.domain.persistence_ports.school;

import es.upm.miw.apaw_practice.domain.models.school.School;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SchoolPersistence {

    Stream<School> readAll();

    School create(School school);

    School read(String name);

    School readByName(String name);

    boolean existName(String name);
}
