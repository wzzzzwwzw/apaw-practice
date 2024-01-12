package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Court;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Instructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class AcademyEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private String city;
    @DBRef
    private List<InstructorEntity> instructors;
    private List<CourtEntity> courts;

    public AcademyEntity() {
        // Empty for framework
    }

    public AcademyEntity(String name, String address, String city, List<InstructorEntity> instructors, List<CourtEntity> courts) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.city = city;
        this.instructors = instructors;
        this.courts = courts;
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

    public List<InstructorEntity> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<InstructorEntity> instructors) {
        this.instructors = instructors;
    }

    public List<CourtEntity> getCourts() {
        return courts;
    }

    public void setCourtEntities(List<CourtEntity> courts) {
        this.courts = courts;
    }

    public Academy toAcademy() {
        Academy academy = new Academy();
        academy.setName(this.getName());
        academy.setAddress(this.getAddress());
        academy.setCity(this.getCity());
        List<Instructor> instructorsList = this.instructors.stream()
                .map(InstructorEntity::toInstructor)
                .toList();
        List<Court> courtList = this.courts.stream()
                .map(CourtEntity::toCourt)
                .toList();
        academy.setInstructors(instructorsList);
        academy.setCourts(courtList);
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
                ", instructors=" + instructors +
                ", courts=" + courts +
                '}';
    }
}
