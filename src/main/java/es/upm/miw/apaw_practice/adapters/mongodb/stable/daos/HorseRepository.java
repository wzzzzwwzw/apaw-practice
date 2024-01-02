package es.upm.miw.apaw_practice.adapters.mongodb.stable.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.HorseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HorseRepository extends MongoRepository<HorseEntity, String> {
    Optional<HorseEntity> findByName(String name);

    int deleteByName(String name);
}
