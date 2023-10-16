package es.upm.miw.apaw_practice.domain.models.hospital;

public class Doctor {

    private String medicalLicenseCode;
    private String office;
    private Department department;

    public Doctor() {

    }

    public Doctor(String medicalLicenseCode, String office, Department department) {
        this.medicalLicenseCode = medicalLicenseCode;
        this.office = office;
        this.department = department;
    }

    public String getMedicalLicenseCode() {
        return medicalLicenseCode;
    }

    public void setMedicalLicenseCode(String medicalLicenseCode) {
        this.medicalLicenseCode = medicalLicenseCode;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
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
                ", office='" + office + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
