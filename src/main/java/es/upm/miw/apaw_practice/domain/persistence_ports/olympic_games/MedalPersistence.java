package es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.Medal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedalPersistence {

    Medal readByMedalId(String id);

    Medal update(Medal medal);

    List<String> findCompetitorsByCompetition(String competition);

    List<String> findTiersByCompetitor(List<String> competitorsNames);
}
