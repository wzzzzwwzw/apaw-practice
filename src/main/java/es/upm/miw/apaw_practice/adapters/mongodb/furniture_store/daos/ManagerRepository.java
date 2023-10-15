package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.ManagerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ManagerRepository extends MongoRepository<ManagerEntity, String> {
    Optional<ManagerEntity> findByAffiliationNumber(String affiliationNumber);
    int deleteByName(String name);
}
