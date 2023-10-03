package es.upm.miw.apaw_practice.domain.models.car_workshop;

import java.math.BigDecimal;

public class CarComponent {
    private String name;
    private BigDecimal price;
    private Integer stock;

    public CarComponent(String name, BigDecimal price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public CarComponent() {
        // empty for framework
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
}
