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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarComponentEntity other = (CarComponentEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CarComponentEntity [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
    }
}
