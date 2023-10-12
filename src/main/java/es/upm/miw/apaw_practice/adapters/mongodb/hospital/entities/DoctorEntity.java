package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import es.upm.miw.apaw_practice.domain.models.hospital.Doctor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class DoctorEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String medicalLicenseCode;
    private String office;
    private DepartmentEntity departmentEntity;

    public DoctorEntity() {
        //empty for framework
    }

    public DoctorEntity(String medicalLicenseCode, String office, DepartmentEntity departmentEntity) {
        this.id = UUID.randomUUID().toString();
        this.medicalLicenseCode = medicalLicenseCode;
        this.office = office;
        this.departmentEntity = departmentEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    public Doctor toDoctor() {
        Doctor doctor = new Doctor();
        BeanUtils.copyProperties(this, doctor);
        return doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEntity that = (DoctorEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(medicalLicenseCode, that.medicalLicenseCode) && Objects.equals(office, that.office) && Objects.equals(departmentEntity, that.departmentEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medicalLicenseCode, office, departmentEntity);
    }

    @Override
    public String toString() {
        return "DoctorEntity{" +
                "id='" + id + '\'' +
                ", medicalLicenseCode='" + medicalLicenseCode + '\'' +
                ", office='" + office + '\'' +
                ", departmentEntity=" + departmentEntity +
                '}';
    }
}
