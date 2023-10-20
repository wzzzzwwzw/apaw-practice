package es.upm.miw.apaw_practice.domain.persistence_ports.bank;

import es.upm.miw.apaw_practice.adapters.rest.bank.dto.IncrementBalanceDto;
import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface BankPersistence {

    Bank readByBankName(String bankName);
    Bank createBank(Bank bank);

    Bank updateBankCapital(Bank bank);

    BankAccount updateIncreaseBankAccountBalance(String bankName, IncrementBalanceDto bodyIncrement);


}
