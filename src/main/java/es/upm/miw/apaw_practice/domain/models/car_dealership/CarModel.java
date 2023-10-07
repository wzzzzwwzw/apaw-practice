package es.upm.miw.apaw_practice.domain.models.car_dealership;

import java.time.LocalDate;

public class CarModel {
    private String name;
    private String brand;
    private LocalDate createDate;

    public CarModel(String name, String brand, LocalDate createDate) {
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

    @Override
    public String toString() {
        return "CarModel{" +
                "model='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
