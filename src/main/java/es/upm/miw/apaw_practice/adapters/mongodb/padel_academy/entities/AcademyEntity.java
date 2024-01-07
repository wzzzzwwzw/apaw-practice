package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class AcademyEntity {
    @Id
    private String name;
    private String address;
    private String city;
    @DBRef
    private List<InstructorEntity> instructorEntities;
    private List<CourtEntity> courtEntities;

    public AcademyEntity() {
        // Empty for framework
    }

    public AcademyEntity(String name, String address, String city, List<InstructorEntity> instructorEntities, List<CourtEntity> courtEntities) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.instructorEntities = instructorEntities;
        this.courtEntities = courtEntities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<InstructorEntity> getInstructorEntities() {
        return instructorEntities;
    }

    public void setInstructorEntities(List<InstructorEntity> instructorEntities) {
        this.instructorEntities = instructorEntities;
    }

    public List<CourtEntity> getCourtEntities() {
        return courtEntities;
    }

    public void setCourtEntities(List<CourtEntity> courtEntities) {
        this.courtEntities = courtEntities;
    }

    public Academy toAcademy() {
        Academy academy = new Academy();
        BeanUtils.copyProperties(this, academy);
        return academy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademyEntity that = (AcademyEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "AcademyEntity{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", instructorEntities=" + instructorEntities +
                ", courtEntities=" + courtEntities +
                '}';
    }
}
