package es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitorPersistence {

    Competitor create(Competitor competitor);

    boolean existName(String name);
}
