package es.upm.miw.apaw_practice.domain.persistence_ports.film;

import org.springframework.stereotype.Repository;

@Repository
public interface GenrePersistence {

    void delete(String name);
}
