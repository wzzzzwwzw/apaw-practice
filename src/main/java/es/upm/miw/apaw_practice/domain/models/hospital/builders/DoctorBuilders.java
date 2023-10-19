package es.upm.miw.apaw_practice.domain.models.hospital.builders;

import es.upm.miw.apaw_practice.domain.models.hospital.Department;
import es.upm.miw.apaw_practice.domain.models.hospital.Doctor;

public interface DoctorBuilders {
    interface  MedicalLicenseCode{
        Optionals medicalLicenseCode(String medicalLicenseCode);
    }
    interface Optionals {
        Optionals speciality(String speciality);
        Optionals department(Department department);
        Doctor build();
    }
}
