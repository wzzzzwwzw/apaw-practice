package es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.OlympicGames;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OlympicGamesPersistence {

    OlympicGames readByEdition(Integer edition);

    OlympicGames updateHostingPlace(Integer edition, String hostingPlace);

    List<OlympicGames> findOlympicGamesPlaceStreamByCompetition(List<String> competitorNames);
}
