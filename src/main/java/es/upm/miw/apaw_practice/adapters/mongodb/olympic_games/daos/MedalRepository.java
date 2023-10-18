package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.MedalEntity;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Medal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MedalRepository extends MongoRepository<MedalEntity, String> {
    Optional<MedalEntity> findByMedalID(String medalID);
}
