package es.upm.miw.apaw_practice.domain.models.film;

import java.time.LocalDate;

public class Director {

    private String dni;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    public Director() {
    }

    public Director(String dni, String name, String surname, LocalDate dateOfBirth) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
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
    public String toString() {
        return "Director{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public static class Builder implements DirectorBuilders.Dni, DirectorBuilders.Name, DirectorBuilders.Optionals {
        private final Director director;

        public Builder() {
            this.director = new Director();
        }

        @Override
        public DirectorBuilders.Name dni(String dni) {
            this.director.dni = dni;
            return this;
        }

        @Override
        public DirectorBuilders.Optionals name(String name) {
            this.director.name = name;
            return this;
        }

        @Override
        public DirectorBuilders.Optionals surname(String surname) {
            this.director.surname = surname;
            return this;
        }

        @Override
        public DirectorBuilders.Optionals dateOfBirth(LocalDate dateOfBirth) {
            this.director.dateOfBirth = dateOfBirth;
            return this;
        }

        @Override
        public Director build() {
            return this.director;
        }
    }
}
