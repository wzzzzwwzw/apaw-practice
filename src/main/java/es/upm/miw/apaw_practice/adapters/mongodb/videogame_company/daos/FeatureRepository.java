package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.FeatureEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FeatureRepository extends MongoRepository<FeatureEntity, String>{
    Optional<FeatureEntity> findByGenre(String name);

}
