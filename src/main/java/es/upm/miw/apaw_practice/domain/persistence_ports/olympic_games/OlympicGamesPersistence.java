package es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.OlympicGames;
import org.springframework.stereotype.Repository;

@Repository
public interface OlympicGamesPersistence {

    OlympicGames readByEdition(Integer edition);
}
