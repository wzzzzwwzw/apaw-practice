package es.upm.miw.apaw_practice.domain.models.food_delivery;

import java.util.List;

public class Client {

    private String identity;
    private String email;
    private String telephone;
    private List<Order> orders;

    public Client(String identity, String email, String telephone, List<Order> orders) {
        this.identity = identity;
        this.email = email;
        this.telephone = telephone;
        this.orders = orders;

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "identity='" + identity + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", orders=" + orders +
                '}';
    }
}
