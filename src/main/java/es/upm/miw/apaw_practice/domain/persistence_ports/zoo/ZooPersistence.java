package es.upm.miw.apaw_practice.domain.persistence_ports.zoo;

import org.springframework.stereotype.Repository;

@Repository
public interface ZooPersistence {
    void delete(String name);
}
