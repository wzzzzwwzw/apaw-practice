package es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;
import org.springframework.stereotype.Repository;

@Repository
public interface GameEnginePersistence {
    GameEngine read(String name);
}
