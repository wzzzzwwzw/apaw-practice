package es.upm.miw.apaw_practice.domain.persistence_ports.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballCompetition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballCompetitionPersistence {
    FootballCompetition readByOrganizingEntity(String organizingEntity);
    void delete(String organizingEntity);
    List<String> getNamesByOrganizingEntity(String organizingEntity);
}
