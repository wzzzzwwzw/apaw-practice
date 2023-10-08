package es.upm.miw.apaw_practice.adapters.mongodb.subway.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.SubwayEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubwayRepository extends MongoRepository<SubwayEntity, String> {
    Optional<SubwayEntity> findByCity(String city);
}
