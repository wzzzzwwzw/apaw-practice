package es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games;

import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinePersistence {

    void delete(String name);

}
