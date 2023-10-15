package es.upm.miw.apaw_practice.domain.persistence_ports.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballPlayer;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballPlayerPersistence {
    FootballPlayer readByName(String name);
    FootballPlayer updateGoals(String name, Integer goals);
}
