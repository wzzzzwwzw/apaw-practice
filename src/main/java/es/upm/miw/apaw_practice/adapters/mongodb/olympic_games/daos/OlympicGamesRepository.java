package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.OlympicGamesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OlympicGamesRepository extends MongoRepository<OlympicGamesEntity, Integer> {
    Optional<OlympicGamesEntity> findByEdition(Integer edition);
}
