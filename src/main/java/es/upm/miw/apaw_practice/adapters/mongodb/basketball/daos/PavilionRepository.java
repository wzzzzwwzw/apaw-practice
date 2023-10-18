package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.PavilionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PavilionRepository extends MongoRepository<PavilionEntity, String> {
    Optional<PavilionEntity> findByPavname(String pavname);
}
