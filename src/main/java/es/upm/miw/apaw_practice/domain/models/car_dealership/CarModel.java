package es.upm.miw.apaw_practice.domain.models.car_dealership;

import java.time.LocalDate;

public class CarModel {
    private String name;
    private String brand;
    private LocalDate createDate;

    public CarModel() {
        //empty from framework
    }

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
    public static class CarModelBuilder {
        private final CarModel carModel;
        private final Car.CarBuilder carBuilder;

        public CarModelBuilder(Car.CarBuilder carBuilder) {
            this.carModel = new CarModel();
            this.carBuilder = carBuilder;
        }

        public CarModelBuilder name(String name) {
            this.carModel.setName(name);
            return this;
        }

        public CarModelBuilder brand(String brand) {
            this.carModel.setBrand(brand);
            return this;
        }

        public CarModelBuilder createDate(LocalDate createDate) {
            this.carModel.setCreateDate(createDate);
            return this;
        }

        public Car.CarBuilder build() {
             carBuilder.addCarModel(this.carModel);
            return this.carBuilder;
        }
    }
}
