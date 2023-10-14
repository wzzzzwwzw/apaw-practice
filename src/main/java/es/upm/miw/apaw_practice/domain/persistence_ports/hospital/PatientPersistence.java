package es.upm.miw.apaw_practice.domain.persistence_ports.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Patient;

public interface PatientPersistence {
        Patient read(String socialInsuranceNumber);

        boolean existsPatientSocialInsuranceNumber(String socialInsuranceNumber);

        Patient create(Patient patient);

}
