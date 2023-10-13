package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.PatientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PatientRepository extends MongoRepository<PatientEntity, String> {
    Optional<PatientEntity> findBySocialInsuranceNumber(String socialInsuranceNumber);

}
