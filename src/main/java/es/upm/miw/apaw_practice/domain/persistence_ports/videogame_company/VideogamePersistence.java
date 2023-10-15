package es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company;

import org.springframework.stereotype.Repository;

@Repository
public interface VideogamePersistence {
    void delete(String name);
}
