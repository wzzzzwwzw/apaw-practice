package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
@Document
public class ClientEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String address;
    private String phoneNumber;
    private List<TransactionEntity> transactionsEntities;
    @DBRef
    private List<CoffeeEntity> coffeesEntities;
    @DBRef
    private DiningEntity diningEntity;

    public ClientEntity() {
        //empty from framework
    }

    public ClientEntity(String id, String name, String address, String phoneNumber, List<TransactionEntity> transactionsEntities, List<CoffeeEntity> coffeesEntities, DiningEntity diningEntity) {
        this.id = UUID.randomUUID().toString();;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.transactionsEntities = transactionsEntities;
        this.coffeesEntities = coffeesEntities;
        this.diningEntity = diningEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<TransactionEntity> getTransactionsEntities() {
        return transactionsEntities;
    }

    public void setTransactionsEntities(List<TransactionEntity> transactionsEntities) {
        this.transactionsEntities = transactionsEntities;
    }

    public List<CoffeeEntity> getCoffeesEntities() {
        return coffeesEntities;
    }

    public void setCoffeesEntities(List<CoffeeEntity> coffeesEntities) {
        this.coffeesEntities = coffeesEntities;
    }

    public DiningEntity getDiningEntity() {
        return diningEntity;
    }

    public void setDiningEntity(DiningEntity diningEntity) {
        this.diningEntity = diningEntity;
    }

    public void fromClient(Client client) {
        BeanUtils.copyProperties(client, this);
    }

    public Client toClient() {
        Client client = new Client();
        BeanUtils.copyProperties(this, client);
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(transactionsEntities, that.transactionsEntities) && Objects.equals(coffeesEntities, that.coffeesEntities) && Objects.equals(diningEntity, that.diningEntity);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
