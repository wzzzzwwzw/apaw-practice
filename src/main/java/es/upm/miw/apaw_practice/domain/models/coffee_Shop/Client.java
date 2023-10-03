package es.upm.miw.apaw_practice.domain.models.coffee_Shop;


import java.util.List;
import java.util.Objects;

public class Client {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Transaction> transactions;
    private List<Feedback> feedbacks;
    private List<Coffee> coffees;

    public Client(String name, String address, String phoneNumber, List<Transaction> transactions, List<Feedback> feedbacks, List<Coffee> coffees) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.transactions = transactions;
        this.feedbacks = feedbacks;
        this.coffees = coffees;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", transactions=" + transactions +
                ", feedbacks=" + feedbacks +
                ", coffees=" + coffees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(address, client.address) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(transactions, client.transactions) && Objects.equals(feedbacks, client.feedbacks) && Objects.equals(coffees, client.coffees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber, transactions, feedbacks, coffees);
    }
}
