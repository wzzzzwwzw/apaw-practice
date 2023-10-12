package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CarModel;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class CarModelEntity {
    private String name;
    private String brand;
    private LocalDate createDate;

    public CarModelEntity(String name, String brand, LocalDate createDate) {
        this.name = name;
        this.brand = brand;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public CarModel toCarModel() {
        CarModel carModel = new CarModel();
        BeanUtils.copyProperties(this, carModel);
        return carModel;
    }

    @Override
    public String toString() {
        return "CarModelEntity{" +
                "model='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
