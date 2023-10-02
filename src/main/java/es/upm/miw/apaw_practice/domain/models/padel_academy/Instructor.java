package es.upm.miw.apaw_practice.domain.models.padel_academy;

import java.time.LocalDate;
import java.util.List;

public class Instructor {
    private String dni;
    private String name;
    private Integer phoneNumber;
    private List<Lesson> lessons;

    public Instructor(String dni, String name, Integer phoneNumber, List<Lesson> lessons) {
        this.dni = dni;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.lessons = lessons;
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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", lessons=" + lessons +
                '}';
    }
}
