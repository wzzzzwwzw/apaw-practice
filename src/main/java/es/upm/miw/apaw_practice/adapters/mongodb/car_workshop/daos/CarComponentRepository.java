package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.CarComponentEntity;

import java.util.Optional;

public interface CarComponentRepository extends MongoRepository<CarComponentEntity, String> {

    Optional<CarComponentEntity> findByName(String name);
}
