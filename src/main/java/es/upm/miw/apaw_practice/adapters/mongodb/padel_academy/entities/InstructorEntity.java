package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Instructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class InstructorEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private String name;
    private Integer phoneNumber;

    public InstructorEntity() {
        // Empty for framework
    }

    public InstructorEntity(String dni, String name, Integer phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.dni = dni;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Instructor toInstructor(){
        Instructor instructor = new Instructor();
        BeanUtils.copyProperties(this, instructor);
        return instructor;
    }

    public void fromInstructor(Instructor instructor) {
        BeanUtils.copyProperties(instructor, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorEntity that = (InstructorEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "InstructorEntity{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
