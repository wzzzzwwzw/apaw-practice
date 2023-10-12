package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos;

import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;
import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.OBDFaultEntity;

import java.util.Optional;

public interface OBDFaultRepository extends MongoRepository<OBDFaultEntity, String> {
    Optional<OBDFaultEntity> findByCode(String code);
}
