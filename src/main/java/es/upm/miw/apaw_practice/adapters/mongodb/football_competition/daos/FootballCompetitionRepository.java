package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballCompetitionEntity;

import java.util.Optional;

public interface FootballCompetitionRepository {
    Optional<FootballCompetitionEntity> findByOrganizingEntity(String organizingEntity);
}
