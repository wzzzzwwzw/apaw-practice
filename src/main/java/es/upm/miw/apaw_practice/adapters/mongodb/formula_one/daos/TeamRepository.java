package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.TeamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeamRepository extends MongoRepository<TeamEntity, String>{
    Optional<TeamEntity> findByTeamName(String teamName);
}
