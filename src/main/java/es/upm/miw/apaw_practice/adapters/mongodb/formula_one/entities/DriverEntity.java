package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities;

import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class DriverEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private Integer number;
    private String driverName;
    private String nationality;
    private Float points;

    public DriverEntity() {
        //empty for framework
    }

    public DriverEntity(Integer number, String driverName, String nationality) {
        this.id = UUID.randomUUID().toString();
        this.number = number;
        this.driverName = driverName;
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }

    public void fromDriver(Driver driver) {
        BeanUtils.copyProperties(driver, this);
    }

    public Driver toDriver() {
        Driver driver = new Driver();
        BeanUtils.copyProperties(this, driver);
        return driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverEntity that = (DriverEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(number, that.number) && Objects.equals(driverName, that.driverName) && Objects.equals(nationality, that.nationality) && Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, driverName, nationality, points);
    }

    @Override
    public String toString() {
        return "DriverEntity{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", driverName='" + driverName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", points=" + points +
                '}';
    }
}
