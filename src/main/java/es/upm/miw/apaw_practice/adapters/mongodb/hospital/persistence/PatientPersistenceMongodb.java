package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.PatientRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.PatientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("patientPersistence")
public class PatientPersistenceMongodb implements PatientPersistence {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientPersistenceMongodb(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient read(String socialInsuranceNumber) {
        return this.patientRepository
                .findBySocialInsuranceNumber(socialInsuranceNumber)
                .orElseThrow(() -> new NotFoundException("Patient socialInsuranceNumber: " + socialInsuranceNumber))
                .toPatient();
    }




}
