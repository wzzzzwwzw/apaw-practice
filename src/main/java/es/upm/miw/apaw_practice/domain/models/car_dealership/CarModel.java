package es.upm.miw.apaw_practice.domain.models.car_dealership;

import java.time.LocalDate;

public class CarModel {
    private String model;
    private String brand;
    private LocalDate createDate;

    public CarModel(String model, String brand, LocalDate createDate) {
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
        return "CarModel{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
