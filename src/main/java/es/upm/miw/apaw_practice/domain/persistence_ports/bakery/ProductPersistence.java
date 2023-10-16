package es.upm.miw.apaw_practice.domain.persistence_ports.bakery;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductPersistence {

    void delete(String name);
}
