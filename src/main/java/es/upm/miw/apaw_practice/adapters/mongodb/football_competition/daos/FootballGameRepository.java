package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballGameEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FootballGameRepository extends MongoRepository<FootballGameEntity, String> {
    Optional<List<FootballGameEntity>> findByLocation(String location);
}
