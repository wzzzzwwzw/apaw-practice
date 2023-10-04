package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.CarToRepairEntity;

public interface CarToRepairRepository extends MongoRepository<CarToRepairEntity, String> {

    Optional<CarToRepairEntity> findByRegistrationNumber(String registrationNumber);
}
