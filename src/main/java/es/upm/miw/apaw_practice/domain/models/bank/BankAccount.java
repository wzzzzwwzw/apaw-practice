package es.upm.miw.apaw_practice.domain.models.bank;

import es.upm.miw.apaw_practice.domain.models.bank.builders.BankAccountBuilder;

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

    public static BankAccountBuilder.NumAccount builder(){return new Builder();}

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
                "numAccount='" + this.numAccount + '\'' +
                ", expiration=" + this.expiration +
                ", cvv=" + this.cvv +
                ", balance=" + this.balance +
                '}';
    }

    public static class Builder implements BankAccountBuilder.NumAccount, BankAccountBuilder.Expiration,BankAccountBuilder.Cvv,BankAccountBuilder.Balance,BankAccountBuilder.Build {
        private final BankAccount bankAccount;


        public Builder(){
            this.bankAccount=new BankAccount();
        }

        @Override
        public BankAccountBuilder.Expiration numAccount(String numAccount) {
            this.bankAccount.setNumAccount(numAccount);
            return this;
        }

        @Override
        public BankAccountBuilder.Cvv expiration(LocalDate expiration) {
            this.bankAccount.setExpiration(expiration);
            return this;
        }

        @Override
        public BankAccountBuilder.Balance cvv(Integer cvv) {
            this.bankAccount.setCvv(cvv);
            return this;
        }

        @Override
        public BankAccountBuilder.Build balance(BigDecimal balance) {
            this.bankAccount.setBalance(balance);
            return this;
        }

        @Override
        public BankAccount build() {
            return this.bankAccount;
        }
    }
}
