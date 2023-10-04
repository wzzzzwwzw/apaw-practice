package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.OBDFaultEntity;

public interface OBDFaultRepository extends MongoRepository<OBDFaultEntity, String> {

    Optional<OBDFaultEntity> findBYCode(String code);
}
