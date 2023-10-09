package es.upm.miw.apaw_practice.adapters.mongodb.school.entities;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import es.upm.miw.apaw_practice.domain.models.school.School;
import es.upm.miw.apaw_practice.domain.models.school.Student;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class SchoolEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String address;
    private LocalDate openingDate;
    private BigDecimal registrationPrice;
    @DBRef
    private List<Student> students;

    public SchoolEntity() {
        //empty from framework
    }

    public SchoolEntity(School school) {
        BeanUtils.copyProperties(school, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "SchoolEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", openingDate=" + openingDate +
                ", registrationPrice=" + registrationPrice +
                ", students=" + students +
                '}';
    }
}
