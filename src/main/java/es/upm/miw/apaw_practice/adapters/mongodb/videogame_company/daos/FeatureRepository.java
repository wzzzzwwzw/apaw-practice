package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.FeatureEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeatureRepository extends MongoRepository<FeatureEntity, String>{

}
