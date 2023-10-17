package es.upm.miw.apaw_practice.domain.models.bank;

import java.util.List;

public class ClientBank {
    private String clientName;
    private String dni;
    private String lastName;
    private Integer age;

    private List<BankAccount> listAccounts;
    public ClientBank(){
        //empty for framework
    }
    public ClientBank(String clientName, String dni, String lastName, Integer age, List<BankAccount> listAccounts){
        this.clientName=clientName;
        this.dni=dni;
        this.lastName=lastName;
        this.age=age;
        this.listAccounts=listAccounts;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getDni() {
        return this.dni;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public List<BankAccount> getListAccounts() {
        return this.listAccounts;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setListAccounts(List<BankAccount> listAccounts) {
        this.listAccounts = listAccounts;
    }

    public void addAccount(BankAccount account){
        this.listAccounts.add(account);
    }
    public void deleteAccount(BankAccount account){
        this.listAccounts.remove(account);
    }
    public Integer getNumAccounts(){
        return this.listAccounts.size();
    }
    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", dni='" + dni + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", listAccounts=" + listAccounts +
                '}';
    }
}
