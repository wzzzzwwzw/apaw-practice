package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;


import es.upm.miw.apaw_practice.domain.models.bank.ClientBank;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class ClientBankEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private String clientName;
    private String lastName;
    private Integer age;
    private List<BankAccountEntity> listAccountsEntities;

    public ClientBankEntity() {

    }

    public ClientBankEntity(String clientName, String dni, String lastName, Integer age, List<BankAccountEntity> listAccountsEntities) {
        this.id= UUID.randomUUID().toString();
        this.dni=dni;
        this.clientName=clientName;
        this.lastName=lastName;
        this.age=age;
        this.listAccountsEntities=listAccountsEntities;
    }

    public String getId() {
        return this.id;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getDni() {
        return this.dni;
    }

    public List<BankAccountEntity> getListAccountsEntities() {
        return this.listAccountsEntities;
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

    public ClientBank toClientBank(){
        ClientBank clientBank =new ClientBank();
        BeanUtils.copyProperties(this, clientBank);
        clientBank.setListAccounts(
                listAccountsEntities.stream()
                        .map(BankAccountEntity::toBankAccount)
                        .toList()
        );
        return clientBank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientBankEntity that = (ClientBankEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni);
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id='" + this.id + '\'' +
                ", dni='" + this.dni + '\'' +
                ", clientName='" + this.clientName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", age=" + this.age +
                ", listAccountsEntities=" + this.listAccountsEntities +
                '}';
    }
}
