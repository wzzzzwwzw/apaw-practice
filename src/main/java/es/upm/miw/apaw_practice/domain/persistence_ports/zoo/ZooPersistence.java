package es.upm.miw.apaw_practice.domain.persistence_ports.zoo;

import es.upm.miw.apaw_practice.domain.models.zoo.Zoo;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooPersistence {
    void delete(String name);

    Zoo read(String name);

    void update(String name, Zoo zoo);
}
