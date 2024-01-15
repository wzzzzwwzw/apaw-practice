package es.upm.miw.apaw_practice.domain.persistence_ports.bank;


import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BankPersistence {

    Bank readByBankName(String bankName);
    Bank createBank(Bank bank);

    Bank updateBank(String bankName,Bank bank);

    BankAccount updateIncreaseBankAccountBalance(String bankName,String numAccount, BigDecimal increment);


}
