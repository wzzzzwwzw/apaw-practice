package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.TeamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeamBasketballRepository extends MongoRepository<TeamEntity, String> {
    Optional<TeamEntity> findByAlias(String alias);
}
