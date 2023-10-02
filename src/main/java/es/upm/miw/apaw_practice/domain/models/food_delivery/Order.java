package es.upm.miw.apaw_practice.domain.models.food_delivery;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {

    private Integer number;
    private BigDecimal price;
    private Boolean delivered;
    private BigDecimal weight;
    private LocalDate date;
    private String paymentMethod;
    private Restaurant restaurant;
    private Transport transport;


    public Order(Integer number, BigDecimal price, Boolean delivered, BigDecimal weight,
                 LocalDate date, String paymentMethod, Restaurant restaurant, Transport transport) {
        this.number = number;
        this.price = price;
        this.delivered = delivered;
        this.weight = weight;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.restaurant = restaurant;
        this.transport = transport;


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

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", price=" + price +
                ", delivered=" + delivered +
                ", weight=" + weight +
                ", date=" + date +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", restaurant=" + restaurant +
                ", transport=" + transport +
                '}';
    }
}

