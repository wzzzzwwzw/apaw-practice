package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities;

import es.upm.miw.apaw_practice.domain.models.food_delivery.Restaurant;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Transport;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class TransportEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String code;
    private Boolean avalaible;
    private BigDecimal capacity;
    private String licensePlate;
    @DBRef
    private List<RestaurantEntity> restaurants;

    public TransportEntity() {

    }

    public TransportEntity(String code, Boolean avalaible, BigDecimal capacity, String licensePlate, List<RestaurantEntity> restaurants) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
        this.avalaible = avalaible;
        this.capacity = capacity;
        this.licensePlate = licensePlate;
        this.restaurants = restaurants;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<RestaurantEntity> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantEntity> restaurants) {
        this.restaurants = restaurants;
    }

    public Transport toTransport(){
        Transport transport = new Transport();
        BeanUtils.copyProperties(this, transport);
        List<Restaurant> restaurants = this.getRestaurants()
                .stream()
                .map(RestaurantEntity::toRestaurant)
                .toList();
        transport.setRestaurants(restaurants);
        return transport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportEntity that = (TransportEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) &&
                Objects.equals(avalaible, that.avalaible) && Objects.equals(capacity, that.capacity) &&
                Objects.equals(licensePlate, that.licensePlate) && Objects.equals(restaurants, that.restaurants);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "TransportEntity{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", avalaible=" + avalaible +
                ", capacity=" + capacity +
                ", licensePlate='" + licensePlate + '\'' +
                ", restaurants=" + restaurants +
                '}';
    }
}
