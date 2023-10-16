package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DoctorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DoctorRepository extends MongoRepository<DoctorEntity, String> {
    Optional<DoctorEntity> findByMedicalLicenseCode(String medicalLicenseCode);
    void deleteByMedicalLicenseCode(String medicalLicenseCode);

}
