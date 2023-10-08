package es.upm.miw.apaw_practice.domain.persistence_ports.conference;

import org.springframework.stereotype.Repository;

@Repository
public interface ConferencePersistence {
    void delete(String id);
}
