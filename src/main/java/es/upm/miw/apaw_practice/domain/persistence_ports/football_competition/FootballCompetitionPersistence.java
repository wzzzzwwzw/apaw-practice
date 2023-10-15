package es.upm.miw.apaw_practice.domain.persistence_ports.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballCompetition;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballCompetitionPersistence {
    FootballCompetition readByOrganizingEntity(String organizingEntity);
    void delete(String organizingEntity);
}
