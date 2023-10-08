package es.upm.miw.apaw_practice.domain.models.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankAccount {
    private String numAccount;
    private LocalDate expiration;
    private Integer cvv;
    private BigDecimal balance;


    public BankAccount(){
        //empty for framework
    }

    public BankAccount(String numAccount,LocalDate expiration,Integer cvv,BigDecimal balance){
        this.numAccount=numAccount;
        this.expiration=expiration;
        this.cvv=cvv;
        this.balance=balance;
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

    @Override
    public String toString() {
        return "BankAccount{" +
                "numAccount='" + numAccount + '\'' +
                ", expiration=" + expiration +
                ", cvv=" + cvv +
                ", balance=" + balance +
                '}';
    }
}
