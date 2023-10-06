package es.upm.miw.apaw_practice.domain.models.coffee_shop;


import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Transaction> transactions;
    private List<Coffee> coffees;
    private Dining dining;

    public Client() {
        transactions = new ArrayList<>();
        coffees = new ArrayList<>();
        dining = new Dining();
    }

    public Client(String name, String address, String phoneNumber, List<Transaction> transactions, List<Coffee> coffees, Dining dining) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.transactions = transactions;
        this.coffees = coffees;
        this.dining = dining;
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

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    public Dining getDining() {
        return dining;
    }

    public void setDining(Dining dining) {
        this.dining = dining;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", transactions=" + transactions +
                ", coffees=" + coffees +
                ", dining=" + dining +
                '}';
    }
}
