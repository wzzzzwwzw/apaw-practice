package es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.TaxonomicSpecieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaxonomicSpecieRepository extends MongoRepository<TaxonomicSpecieEntity, String> {
}
