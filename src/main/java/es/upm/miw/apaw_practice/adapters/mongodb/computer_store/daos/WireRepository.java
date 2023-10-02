package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.WireEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WireRepository extends MongoRepository<WireEntity, String> {
    Optional<WireEntity> findByName(String name);
}
