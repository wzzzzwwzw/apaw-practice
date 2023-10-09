package es.upm.miw.apaw_practice.adapters.mongodb.film.entities;

import es.upm.miw.apaw_practice.domain.models.film.Director;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDate;
import java.util.UUID;

public class DirectorEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    public DirectorEntity() {}

    public DirectorEntity(Director director) {
        BeanUtils.copyProperties(director, this);
        this.id = UUID.randomUUID().toString();
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (dni.equals(((DirectorEntity) obj).dni));
    }

    @Override
    public String toString() {
        return "DirectorEntity{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
