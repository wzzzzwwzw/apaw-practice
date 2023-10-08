package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballGameEntity;

import java.util.Optional;

public interface FootballGameRepository {
    Optional<FootballGameEntity> findById(String id);
}
