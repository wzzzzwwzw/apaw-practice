package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities;

import es.upm.miw.apaw_practice.domain.models.food_delivery.Restaurant;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class RestaurantEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String type;
    private String description;
    private String adress;
    private Integer maximumOrders;

    public RestaurantEntity() {

    }

    public RestaurantEntity(Restaurant restaurant){
        BeanUtils.copyProperties(restaurant,this);
        this.id = UUID.randomUUID().toString();
    }

    public RestaurantEntity(String name, String type, String description, String adress, Integer maximumOrders) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.description = description;
        this.adress = adress;
        this.maximumOrders = maximumOrders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getMaximumOrders() {
        return maximumOrders;
    }

    public void setMaximumOrders(Integer maximumOrders) {
        this.maximumOrders = maximumOrders;
    }


    public Restaurant toRestaurant() {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(this, restaurant);
        return restaurant;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantEntity that = (RestaurantEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(description, that.description) && Objects.equals(adress, that.adress) && Objects.equals(maximumOrders, that.maximumOrders);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "RestaurantEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", adress='" + adress + '\'' +
                ", maximumOrders=" + maximumOrders +
                '}';
    }
}
