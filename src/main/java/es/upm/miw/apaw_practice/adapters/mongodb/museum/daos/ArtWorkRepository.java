package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtWorkEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtWorkRepository extends MongoRepository<ArtWorkEntity, String> {
}
