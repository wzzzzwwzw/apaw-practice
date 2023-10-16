package es.upm.miw.apaw_practice.adapters.mongodb.stable.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.KeeperEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface KeeperRepository extends MongoRepository<KeeperEntity, String> {
    Optional<KeeperEntity> findByName(String name);
}
