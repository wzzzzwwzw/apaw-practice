package es.upm.miw.apaw_practice.domain.models.hospital;

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
}
