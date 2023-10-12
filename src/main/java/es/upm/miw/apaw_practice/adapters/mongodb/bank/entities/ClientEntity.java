package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;

import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.models.bank.Client;

import org.springframework.beans.BeanUtils;
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
    private String dni;
    private String clientName;
    private String lastName;
    private Integer age;
    private List<BankAccountEntity> listAccountsEntities;

    public ClientEntity() {

    }

    public ClientEntity(String clientName, String dni, String lastName, Integer age, List<BankAccountEntity> listAccountsEntities) {
        this.id= UUID.randomUUID().toString();
        this.clientName=clientName;
        this.lastName=lastName;
        this.age=age;
        this.listAccountsEntities=listAccountsEntities;
    }

    public String getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getDni() {
        return dni;
    }

    public List<BankAccountEntity> getListAccountsEntities() {
        return listAccountsEntities;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setListAccountsEntities(List<BankAccountEntity> listAccountsEntities) {
        this.listAccountsEntities = listAccountsEntities;
    }

    public Client toClient(){
        Client client=new Client();
        BeanUtils.copyProperties(this,client);
        client.setListAccounts(
                listAccountsEntities.stream()
                        .map(BankAccountEntity::toBankAccount)
                        .toList()
        );
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni);
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", clientName='" + clientName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", listAccountsEntities=" + listAccountsEntities +
                '}';
    }
}
