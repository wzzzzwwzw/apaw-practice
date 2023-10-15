package es.upm.miw.apaw_practice.domain.persistence_ports.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Doctor;

public interface DoctorPersistence {

    Doctor read(String medicalLicenseCode);
    boolean existsDoctor(String medicalLicenseCode);
    Doctor create(Doctor doctor);
    void delete(String name);
}
