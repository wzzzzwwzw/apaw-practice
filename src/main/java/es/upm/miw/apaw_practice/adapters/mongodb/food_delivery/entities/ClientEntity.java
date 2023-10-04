package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class ClientEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String identity;
    private String email;
    private String telephone;
    private List<OrderEntity> orders;

    public ClientEntity() {

    }

    public ClientEntity(String identity, String email, String telephone, List<OrderEntity> orders) {
        this.id = UUID.randomUUID().toString();
        this.identity = identity;
        this.email = email;
        this.telephone = telephone;
        this.orders = orders;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(identity, that.identity) && Objects.equals(email, that.email) && Objects.equals(telephone, that.telephone) && Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id='" + id + '\'' +
                ", identity='" + identity + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", orders=" + orders +
                '}';
    }
}
