package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.ComputerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ComputerRepository extends MongoRepository<ComputerEntity, String> {
    Optional<ComputerEntity> findByName(String name);
}
