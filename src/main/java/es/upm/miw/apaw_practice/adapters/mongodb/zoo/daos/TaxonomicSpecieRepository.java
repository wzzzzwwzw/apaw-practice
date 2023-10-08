package es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.TaxonomicSpecieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TaxonomicSpecieRepository extends MongoRepository<TaxonomicSpecieEntity, String> {
    Optional<TaxonomicSpecieEntity> findBySpeciesName(String speciesName);
}
