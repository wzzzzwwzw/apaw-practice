package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.CompetitorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CompetitorRepository extends MongoRepository<CompetitorEntity, String> {
    Optional<CompetitorRepository> findByName(String name);
}
