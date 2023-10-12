package es.upm.miw.apaw_practice.adapters.mongodb.music.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document
public class ArtistEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String dni;

    private String fullName;

    private Integer phoneNumber;

    private LocalDate birthDate;

    public ArtistEntity() {
        //empty for framework
    }

    public ArtistEntity(String dni, String fullName, Integer phoneNumber, LocalDate birthDate) {
        this.id = UUID.randomUUID().toString();
        this.dni = dni;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistEntity that = (ArtistEntity) o;
        return Objects.equals(dni, that.dni) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "ArtistEntity{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", birthDate=" + birthDate +
                '}';
    }
}
