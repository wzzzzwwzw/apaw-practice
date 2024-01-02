package es.upm.miw.apaw_practice.adapters.mongodb.subway.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.StationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StationRepository extends MongoRepository<StationEntity, String> {
    Optional<StationEntity> findByName(String name);

    void deleteByName(String name);
}
