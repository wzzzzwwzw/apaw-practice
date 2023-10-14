package es.upm.miw.apaw_practice.domain.services.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.PatientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientPersistence patientPersistence;

    @Autowired
    public PatientService(PatientPersistence patientPersistence) {
        this.patientPersistence = patientPersistence;
    }

    public Patient read(String socialInsuranceNumber) {
        return this.patientPersistence.read(socialInsuranceNumber);
    }

}
