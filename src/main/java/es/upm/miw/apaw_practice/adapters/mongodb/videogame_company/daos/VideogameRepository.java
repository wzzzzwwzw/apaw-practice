package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.VideogameEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VideogameRepository extends MongoRepository<VideogameEntity, String>{
    Optional<VideogameEntity> findByName(String name);

    void deleteByName(String name);
}
