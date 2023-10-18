package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.TeamBasketballEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeamBasketballRepository extends MongoRepository<TeamBasketballEntity, String> {
    Optional<TeamBasketballEntity> findByAlias(String alias);
}
