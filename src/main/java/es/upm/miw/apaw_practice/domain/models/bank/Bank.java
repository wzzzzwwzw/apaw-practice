package es.upm.miw.apaw_practice.domain.models.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private String location;
    private BigDecimal capital;
    private BankType bankType;
    private List<BankAccount> listAccounts;

    public Bank(){
        //empty for framework
    }
    public Bank(String bankName,String location,BigDecimal capital,BankType bankType){
        this.bankName=bankName;
        this.location=location;
        this.capital=capital;
        this.bankType=bankType;
        this.listAccounts=new ArrayList<BankAccount>();

    }

    public String getBankName() {
        return this.bankName;
    }

    public String getLocation() {
        return this.location;
    }

    public BigDecimal getCapital() {
        return this.capital;
    }

    public BankType getBankType() {
        return this.bankType;
    }

    public List<BankAccount> getListAccounts() {
        return this.listAccounts;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public void setBankType(BankType bankType) {
        this.bankType = bankType;
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
    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", location='" + location + '\'' +
                ", capital=" + capital +
                ", bankType=" + bankType +
                ", listAccounts=" + listAccounts +
                '}';
    }
}
