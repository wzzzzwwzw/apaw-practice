package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballPlayerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FootballPlayerRepository extends MongoRepository<FootballPlayerEntity, String> {
    Optional<FootballPlayerEntity> findByName(String name);
}
