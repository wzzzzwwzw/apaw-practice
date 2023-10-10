package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos;


import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.DisciplineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DisciplineRepository extends MongoRepository<DisciplineEntity, String> {
    Optional<DisciplineEntity> findByName(String name);
}
