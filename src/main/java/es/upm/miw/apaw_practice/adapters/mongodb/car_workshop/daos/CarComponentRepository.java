package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.CarComponentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CarComponentRepository extends MongoRepository<CarComponentEntity, String> {

    Optional<CarComponentEntity> findByName(String name);
}
