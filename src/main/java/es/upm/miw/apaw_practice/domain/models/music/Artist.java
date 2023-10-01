package es.upm.miw.apaw_practice.domain.models.music;

import java.time.LocalDate;

public class Artist {

    private String dni;

    private String fullName;

    private Integer phoneNumber;

    private LocalDate birthDate;

    public Artist() {
        //empty for framework
    }

    public Artist(String dni, String fullName, Integer phoneNumber, LocalDate birthDate) {
        this.dni = dni;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "dni='" + this.dni + '\'' +
                ", fullName='" + this.fullName + '\'' +
                ", phoneNumber=" + this.phoneNumber +
                ", birthDate=" + this.birthDate +
                '}';
    }
}
