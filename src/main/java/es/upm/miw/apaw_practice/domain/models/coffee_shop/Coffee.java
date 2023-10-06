package es.upm.miw.apaw_practice.domain.models.coffee_shop;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Coffee {
    private String coffee;
    private String category;
    private BigDecimal price;

    public Coffee(String coffee, String category, BigDecimal price) {
        this.coffee = coffee;
        this.category = category;
        this.price = price;
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

    @Override
    public String toString() {
        return "Coffee{" +
                "coffee='" + coffee + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
