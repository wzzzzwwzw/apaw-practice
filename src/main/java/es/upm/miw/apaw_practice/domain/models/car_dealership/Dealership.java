package es.upm.miw.apaw_practice.domain.models.car_dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    String name;
    String city;
    String district;
    List<Car> carList;

    public Dealership(String name, String city, String district) {
        this.name = name;
        this.city = city;
        this.district = district;
        this.carList = new ArrayList<>();
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

    public void setCar(Car car) {
        this.carList.add(car);
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
