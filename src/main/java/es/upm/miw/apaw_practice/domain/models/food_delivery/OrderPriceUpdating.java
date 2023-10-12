package es.upm.miw.apaw_practice.domain.models.food_delivery;

import java.math.BigDecimal;

public class OrderPriceUpdating {

    private Integer number;
    private BigDecimal price;

    public OrderPriceUpdating() {
    }

    public OrderPriceUpdating(Integer number, BigDecimal price) {
        this.number = number;
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderPriceUpdating{" +
                "number=" + number +
                ", price=" + price +
                '}';
    }
}
