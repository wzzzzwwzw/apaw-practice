package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;

@Document
public class CarComponentEntity {

    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private Integer stock;

    public CarComponentEntity() {
        // empty for framework
    }

    public CarComponentEntity(CarComponent carComponent) {
        BeanUtils.copyProperties(carComponent, this);
        this.id = UUID.randomUUID().toString();
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public CarComponent toCarComponent() {
        CarComponent carComponent = new CarComponent();
        BeanUtils.copyProperties(this, carComponent);
        return carComponent;
    }
}
