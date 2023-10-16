package es.upm.miw.apaw_practice.adapters.mongodb.stable.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.CareTaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface CareTaskRepository extends MongoRepository<CareTaskEntity, String> {
    Optional<CareTaskEntity> findByDescription(String description);
}
