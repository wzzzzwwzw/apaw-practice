package es.upm.miw.apaw_practice.adapters.rest.bank.dto;

import java.math.BigDecimal;

public class IncrementBalanceDto {


    private String numAccount;

    private BigDecimal increment;

    public IncrementBalanceDto(){

    }

    public IncrementBalanceDto(String numAccount, BigDecimal increment){
        this.numAccount=numAccount;
        this.increment=increment;
    }

    public String getNumAccount() {
        return numAccount;
    }

    public BigDecimal getIncrement() {
        return increment;
    }

    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }

    public void setIncrement(BigDecimal increment) {
        this.increment = increment;
    }
}
