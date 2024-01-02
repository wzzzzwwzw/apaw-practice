package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;


import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class BankEntity {
    @Id
    private String id;

    @Indexed(unique = true)
    private String bankName;
    private String location;
    private BigDecimal capital;
    private BankTypeEntity bankTypeEntity;

    private List<BankAccountEntity> bankAccountEntityList;


    public BankEntity(){

    }

    public BankEntity(String bankName,String location,BigDecimal capital, BankTypeEntity bankTypeEntity){
        this.id= UUID.randomUUID().toString();
        this.bankName=bankName;
        this.location=location;
        this.capital=capital;
        this.bankTypeEntity=bankTypeEntity;
        this.bankAccountEntityList=new ArrayList<BankAccountEntity>();

    }

    public String getId() {
        return this.id;
    }

    public String getBankName() {
        return this.bankName;
    }

    public BigDecimal getCapital() {
        return this.capital;
    }

    public String getLocation() {
        return this.location;
    }

    public BankTypeEntity getBankTypeEntity() {
        return this.bankTypeEntity;
    }

    public List<BankAccountEntity> getBankAccountEntityList() {
        return this.bankAccountEntityList;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBankTypeEntity(BankTypeEntity bankTypeEntity) {
        this.bankTypeEntity = bankTypeEntity;
    }

    public void setBankAccountEntityList(List<BankAccountEntity> bankAccountEntityList) {
        this.bankAccountEntityList = bankAccountEntityList;
    }
    public void addAccountBankFromList(BankAccountEntity account){
        this.bankAccountEntityList.add(account);
    }

    public void removeAccountBankFromList(BankAccountEntity account){
        this.bankAccountEntityList.remove(account);
    }
    public Bank toBank(){
        Bank bank = new Bank();

        bank.setBankName(this.getBankName());
        bank.setLocation(this.getLocation());
        bank.setCapital(this.getCapital());

        if (this.getBankTypeEntity() != null) {
            bank.setBankType(this.getBankTypeEntity().toBankType());
        }
        bank.setListAccounts(
                this.bankAccountEntityList.stream()
                        .map(BankAccountEntity::toBankAccount)
                        .toList()
        );
        System.out.println(bank);
        return bank;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankEntity that = (BankEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(bankName, that.bankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankName);
    }

    @Override
    public String toString() {
        return "BankEntity{" +
                "id='" + this.id + '\'' +
                ", bankName='" + this.bankName + '\'' +
                ", location='" + this.location + '\'' +
                ", capital=" + this.capital +
                ", bankTypeEntity=" + this.bankTypeEntity +
                ", bankAccountEntityList=" + this.bankAccountEntityList +
                '}';
    }
}
