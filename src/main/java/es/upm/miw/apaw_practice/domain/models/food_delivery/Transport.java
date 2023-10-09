package es.upm.miw.apaw_practice.domain.models.food_delivery;

import java.math.BigDecimal;
import java.util.List;

public class Transport {

    private String code;
    private Boolean avalaible;
    private BigDecimal capacity;
    private String licensePlate;
    private List<Restaurant> restaurants;

    public Transport(){}

    public Transport(String code, Boolean avalaible, BigDecimal capacity, String licensePlate, List<Restaurant> restaurants) {
        this.code = code;
        this.avalaible = avalaible;
        this.capacity = capacity;
        this.licensePlate = licensePlate;
        this.restaurants = restaurants;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getAvalaible() {
        return avalaible;
    }

    public void setAvalaible(Boolean avalaible) {
        this.avalaible = avalaible;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "code='" + code + '\'' +
                ", avalaible=" + avalaible +
                ", capacity=" + capacity +
                ", licensePlate='" + licensePlate + '\'' +
                ", restaurants=" + restaurants +
                '}';
    }
}
