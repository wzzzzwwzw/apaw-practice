package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PainterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PainterRepository extends MongoRepository<PainterEntity, String> {
}
