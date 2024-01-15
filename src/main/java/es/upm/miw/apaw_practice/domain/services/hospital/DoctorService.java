package es.upm.miw.apaw_practice.domain.services.hospital;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.hospital.Doctor;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.DoctorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private final DoctorPersistence doctorPersistence;

    @Autowired
    public DoctorService(DoctorPersistence doctorPersistence) {
        this.doctorPersistence = doctorPersistence;
    }

    public Doctor create(Doctor doctor) {
        this.assertDoctorNotExists(doctor.getMedicalLicenseCode());
        return this.doctorPersistence.create(doctor);
    }

    private void assertDoctorNotExists(String medicalLicenseCode) {
        if (this.doctorPersistence.existsDoctor(medicalLicenseCode)) {
            throw new ConflictException("Doctor already exists: " + medicalLicenseCode);
        }
    }

    public void delete(String medicalLicenseCode) {
        this.doctorPersistence.delete(medicalLicenseCode);
    }
}
