package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballTeamEntity;

import java.util.Optional;

public interface FootballTeamRepository {
    Optional<FootballTeamEntity> findByCity(String city);
}
