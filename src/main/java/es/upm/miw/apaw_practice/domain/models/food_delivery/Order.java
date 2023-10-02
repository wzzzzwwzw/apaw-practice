package es.upm.miw.apaw_practice.domain.models.food_delivery;

import java.time.LocalDate;

public class Order {

    private Integer number;
    private Double price;
    private Boolean delivered;
    private Double weight;
    private LocalDate date;
    private String paymentMethod;
    private Restaurant restaurant;
    private Transport transport;


    public Order(Integer number, Double price, Boolean delivered, Double weight,
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
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

