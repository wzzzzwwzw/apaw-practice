package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballCompetitionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FootballCompetitionRepository extends MongoRepository<FootballCompetitionEntity, String> {
    Optional<FootballCompetitionEntity> findByOrganizingEntity(String organizingEntity);
}
