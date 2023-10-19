package es.upm.miw.apaw_practice.domain.models.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.builders.DoctorBuilders;

public class Doctor {

    private String medicalLicenseCode;
    private String speciality;
    private Department department;

    public Doctor() {

    }

    public Doctor(String medicalLicenseCode, String speciality, Department department) {
        this.medicalLicenseCode = medicalLicenseCode;
        this.speciality = speciality;
        this.department = department;
    }

    public String getMedicalLicenseCode() {
        return medicalLicenseCode;
    }

    public void setMedicalLicenseCode(String medicalLicenseCode) {
        this.medicalLicenseCode = medicalLicenseCode;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "medicalLicenseCode=" + medicalLicenseCode +
                ", speciality='" + speciality + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public static class Builder implements DoctorBuilders.MedicalLicenseCode, DoctorBuilders.Optionals {
        private final Doctor doctor;

        public Builder() {
            doctor = new Doctor();
        }

        @Override
        public DoctorBuilders.Optionals medicalLicenseCode(String medicalLicenseCode) {
            this.doctor.medicalLicenseCode = medicalLicenseCode;
            return this;
        }
        @Override
        public DoctorBuilders.Optionals speciality(String speciality) {
            this.doctor.speciality = speciality;
            return this;
        }

        @Override
        public DoctorBuilders.Optionals department(Department department) {
            this.doctor.department = department;
            return this;
        }

        @Override
        public Doctor build() {
            return this.doctor;
        }

    }
}
