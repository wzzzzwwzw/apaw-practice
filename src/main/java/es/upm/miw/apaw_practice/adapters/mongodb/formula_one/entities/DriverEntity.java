package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class DriverEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private Integer number;
    private String driverName;
    private String nationality;
    @DBRef
    private DrivingStyleEntity drivingStyleEntity;
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

    public DrivingStyleEntity getDrivingStyleEntity() {
        return drivingStyleEntity;
    }

    public void setDrivingStyleEntity(DrivingStyleEntity drivingStyleEntity) {
        this.drivingStyleEntity = drivingStyleEntity;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "DriverEntity{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", driverName='" + driverName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", drivingStyleEntity=" + drivingStyleEntity +
                ", points=" + points +
                '}';
    }
}
