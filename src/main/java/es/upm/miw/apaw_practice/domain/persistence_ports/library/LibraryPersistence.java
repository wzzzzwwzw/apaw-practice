package es.upm.miw.apaw_practice.domain.persistence_ports.library;

import es.upm.miw.apaw_practice.domain.models.library.Library;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryPersistence {
    Library read(String name);
}
