package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class CarModelEntity {
    private String model;
    private String brand;
    private LocalDate createDate;

    public CarModelEntity(String model, String brand, LocalDate createDate) {
        this.model = model;
        this.brand = brand;
        this.createDate = createDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    @Override
    public String toString() {
        return "CarModelEntity{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
