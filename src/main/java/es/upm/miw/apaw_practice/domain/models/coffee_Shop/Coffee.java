package es.upm.miw.apaw_practice.domain.models.coffee_Shop;

import java.math.BigDecimal;
import java.util.Objects;

public class Coffee {
    private String name;
    private String category;
    private BigDecimal price;

    public Coffee(String name, String category, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(name, coffee.name) && Objects.equals(category, coffee.category) && Objects.equals(price, coffee.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }
}
