package es.upm.miw.apaw_practice.domain.models.school;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class School {
    private String name;
    private String address;
    private LocalDate openingDate;
    private BigDecimal registrationPrice;
    private List<Student> students;

    public School() {
        //empty from framework
    }

    public School(String name, String address, LocalDate openingDate, BigDecimal registrationPrice) {
        this.name = name;
        this.address = address;
        this.openingDate = openingDate;
        this.registrationPrice = registrationPrice;
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

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public BigDecimal getRegistrationPrice() {
        return registrationPrice;
    }

    public void setRegistrationPrice(BigDecimal registrationPrice) {
        this.registrationPrice = registrationPrice;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", openingDate=" + openingDate +
                ", registrationPrice=" + registrationPrice +
                ", students=" + students +
                '}';
    }
}
