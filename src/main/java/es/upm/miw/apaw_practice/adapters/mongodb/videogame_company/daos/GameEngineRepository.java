package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.GameEngineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GameEngineRepository extends MongoRepository<GameEngineEntity, String>{
    Optional<GameEngineEntity> findByName(String name);
}
