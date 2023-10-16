package es.upm.miw.apaw_practice.domain.models.car_dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String city;
    private String district;
    private List<Car> carList;

    public Dealership() {
        carList = new ArrayList<>();
    }

    public Dealership(String name, String city, String district) {
        this();
        this.name = name;
        this.city = city;
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", carList=" + carList +
                '}';
    }
}
