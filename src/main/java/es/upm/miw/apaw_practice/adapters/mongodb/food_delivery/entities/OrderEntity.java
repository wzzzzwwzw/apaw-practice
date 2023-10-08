package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities;

import es.upm.miw.apaw_practice.domain.models.food_delivery.Order;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document
public class OrderEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private Integer number;
    private BigDecimal price;
    private Boolean delivered;
    private BigDecimal weight;
    private LocalDate date;
    private String paymentMethod;
    @DBRef
    private RestaurantEntity restaurant;
    @DBRef
    private TransportEntity transport;

    public OrderEntity() {
    }

    public OrderEntity(Integer number, BigDecimal price, Boolean delivered, BigDecimal weight,
                       String paymentMethod, RestaurantEntity restaurant, TransportEntity transport) {
        this.id = UUID.randomUUID().toString();
        this.number = number;
        this.price = price;
        this.delivered = delivered;
        this.weight = weight;
        this.date = LocalDate.now();
        this.paymentMethod = paymentMethod;
        this.restaurant = restaurant;
        this.transport = transport;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }

    public TransportEntity getTransport() {
        return transport;
    }

    public void setTransport(TransportEntity transport) {
        this.transport = transport;
    }

    public void fromOrder(Order order) {
        BeanUtils.copyProperties(order, this);
    }

    public Order toOrder() {
        Order order = new Order();
        BeanUtils.copyProperties(this, order);
        return order;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(number, that.number) && Objects.equals(price, that.price) && Objects.equals(delivered, that.delivered) && Objects.equals(weight, that.weight) && Objects.equals(date, that.date) && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(restaurant, that.restaurant) && Objects.equals(transport, that.transport);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id='" + id + '\'' +
                ", number=" + number +
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



