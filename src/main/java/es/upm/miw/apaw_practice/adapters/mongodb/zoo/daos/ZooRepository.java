package es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.ZooEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ZooRepository extends MongoRepository<ZooEntity, String> {
    void deleteByName(String name);

    Optional<ZooEntity> findByName(String name);

}
