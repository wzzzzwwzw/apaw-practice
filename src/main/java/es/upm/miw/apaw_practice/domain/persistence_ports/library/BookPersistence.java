package es.upm.miw.apaw_practice.domain.persistence_ports.library;

import org.springframework.stereotype.Repository;

@Repository
public interface BookPersistence {
    void deleteByIsbn(String isbn);
}
