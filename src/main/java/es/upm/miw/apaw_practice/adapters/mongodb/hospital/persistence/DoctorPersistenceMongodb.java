package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.DoctorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DepartmentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DoctorEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hospital.Doctor;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.DoctorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("doctorPersistence")
public class DoctorPersistenceMongodb implements DoctorPersistence {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorPersistenceMongodb(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor read(String medicalLicenseCode) {
        return this.doctorRepository
                .findByMedicalLicenseCode(medicalLicenseCode)
                .orElseThrow(() -> new NotFoundException("Doctor medicalLicenseCode: " + medicalLicenseCode))
                .toDoctor();
    }

    public boolean existsDoctor(String medicalLicenseCode) {
        return this.doctorRepository
                .findByMedicalLicenseCode(medicalLicenseCode)
                .isPresent();
    }

    public Doctor create(Doctor doctor) {
        DepartmentEntity departmentEntity = new DepartmentEntity(doctor.getDepartment().getDepartmentName(),doctor.getDepartment().getAvailableBeds(),doctor.getDepartment().getFloor());
        return this.doctorRepository
                .save(new DoctorEntity(doctor.getMedicalLicenseCode(),doctor.getOffice(),departmentEntity))
                .toDoctor();
    }

    @Override
    public void delete(String medicalLicenseCode) {
        this.doctorRepository.deleteByMedicalLicenseCode(medicalLicenseCode);
    }

}
