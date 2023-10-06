package es.upm.miw.apaw_practice.domain.models.coffee_shop;


import java.util.List;
import java.util.Objects;

public class Client {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Transaction> transactions;

    public Client(String name, String address, String phoneNumber, List<Transaction> transactions) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.transactions = transactions;
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
