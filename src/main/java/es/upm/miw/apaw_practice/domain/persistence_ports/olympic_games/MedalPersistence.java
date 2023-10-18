package es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.Medal;
import org.springframework.stereotype.Repository;

@Repository
public interface MedalPersistence {

    Medal readByMedalId(String id);

    Medal update(Medal medal);
}
