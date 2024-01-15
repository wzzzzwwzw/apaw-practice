package es.upm.miw.apaw_practice.domain.models.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.builders.CoffeeBuilders;

import java.math.BigDecimal;

public class Coffee {
    private String coffee;
    private String category;
    private BigDecimal price;

    public Coffee() {
    }

    public Coffee(String coffee, String category, BigDecimal price) {
        this.coffee = coffee;
        this.category = category;
        this.price = price;
    }

    public static Coffee.Builder builder() {
        return new Builder();
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

    public static class Builder implements CoffeeBuilders.CoffeeName, CoffeeBuilders.Category, CoffeeBuilders.Price, CoffeeBuilders.Build {
        private final Coffee coffee;

        public Builder() {
            this.coffee = new Coffee();
        }

        @Override
        public CoffeeBuilders.Category coffeeName(String coffee) {
            this.coffee.coffee = coffee;
            return this;
        }

        @Override
        public CoffeeBuilders.Price category(String category) {
            this.coffee.category = category;
            return this;
        }

        @Override
        public CoffeeBuilders.Build price(BigDecimal price) {
            this.coffee.price = price;
            return this;
        }

        @Override
        public Coffee build() {
            return this.coffee;
        }


    }
}
