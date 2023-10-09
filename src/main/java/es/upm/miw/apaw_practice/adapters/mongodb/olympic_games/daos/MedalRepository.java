package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.MedalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedalRepository extends MongoRepository<MedalEntity, String> {
}
