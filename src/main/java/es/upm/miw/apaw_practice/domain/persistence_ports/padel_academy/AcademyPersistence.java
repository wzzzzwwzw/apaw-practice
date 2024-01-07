package es.upm.miw.apaw_practice.domain.persistence_ports.padel_academy;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyPersistence {
    Academy readByName(String name);

    void deleteByName(String name);
}
