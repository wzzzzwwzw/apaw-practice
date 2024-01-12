package es.upm.miw.apaw_practice.domain.persistence_ports.padel_academy;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AcademyPersistence {
    Academy readByName(String name);

    void deleteByName(String name);

    Academy updateAddress(Academy academy);
    Stream<Academy> readAll();

}
