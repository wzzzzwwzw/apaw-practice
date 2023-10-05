package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ExhibitionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExhibitionRepository extends MongoRepository<ExhibitionEntity, String> {
}
