package es.upm.miw.apaw_practice.domain.persistence_ports.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballTeamPersistence {
    FootballTeam read(String city);
}