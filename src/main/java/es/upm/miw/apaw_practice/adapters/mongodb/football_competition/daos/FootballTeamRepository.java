package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballTeamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FootballTeamRepository extends MongoRepository<FootballTeamEntity, String> {
    Optional<FootballTeamEntity> findByCity(String city);
}
