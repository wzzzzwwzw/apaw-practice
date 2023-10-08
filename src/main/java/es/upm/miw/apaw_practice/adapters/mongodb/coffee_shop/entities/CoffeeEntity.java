package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
@Document
public class CoffeeEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String coffee;
    private String category;
    private BigDecimal price;

    public CoffeeEntity() {
        //empty from framework
    }

    public CoffeeEntity(String coffee, String category, BigDecimal price) {
        this.id = UUID.randomUUID().toString();
        this.coffee = coffee;
        this.category = category;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoffee() {
        return coffee;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void fromCoffee(Coffee coffee) {
        BeanUtils.copyProperties(coffee, this);
    }

    public Coffee toCoffee() {
        Coffee coffee = new Coffee();
        BeanUtils.copyProperties(this, coffee);
        return coffee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeEntity that = (CoffeeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(coffee, that.coffee) && Objects.equals(category, that.category) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "CoffeeEntity{" +
                "id='" + id + '\'' +
                ", coffee='" + coffee + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
