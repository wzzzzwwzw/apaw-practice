package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;

import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document
public class BankAccountEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String numAccount;
    private LocalDate expiration;
    private Integer cvv;
    private BigDecimal balance;

    public BankAccountEntity(){
        //empty for framework
    }

    public BankAccountEntity(String numAccount,LocalDate expiration,Integer cvv, BigDecimal balance){
        this.id=UUID.randomUUID().toString();
        this.numAccount=numAccount;
        this.expiration=expiration;
        this.cvv=cvv;
        this.balance=balance;
    }

    public String getId() {
        return this.id;
    }

    public String getNumAccount() {
        return this.numAccount;
    }

    public LocalDate getExpiration() {
        return this.expiration;
    }

    public Integer getCvv() {
        return this.cvv;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public BankAccount toBankAccount(){
        return BankAccount.builder()
                .numAccount(this.numAccount)
                .expiration(this.expiration)
                .cvv(this.cvv)
                .balance(this.balance)
                .build();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountEntity that = (BankAccountEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(numAccount, that.numAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numAccount);
    }

    @Override
    public String toString() {
        return "BankAccountEntity{" +
                "id='" + this.id + '\'' +
                ", numAccount='" + this.numAccount + '\'' +
                ", expiration=" + this.expiration +
                ", cvv=" + this.cvv +
                ", balance=" + this.balance +
                '}';
    }
}
