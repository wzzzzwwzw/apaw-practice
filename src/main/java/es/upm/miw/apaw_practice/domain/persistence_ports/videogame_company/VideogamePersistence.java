package es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogamePersistence {
    void delete(String name);

    Videogame updateReleaseDateByName(String name);
}
