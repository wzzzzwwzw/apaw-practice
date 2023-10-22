package es.upm.miw.apaw_practice.domain.services.bank;

import es.upm.miw.apaw_practice.adapters.rest.bank.dto.IncrementBalanceDto;
import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankService {

    private final BankPersistence bankPersistence;
    @Autowired
    public BankService(BankPersistence bankPersistence){
        this.bankPersistence=bankPersistence;
    }

    public Bank readByBankName(String bankName){
        return this.bankPersistence.readByBankName(bankName);
    }

    public Bank createBank(Bank bank){
        return this.bankPersistence.createBank(bank);
    }

    public Bank updateBank(String bankName, Bank bankUpdate){
        return this.bankPersistence.updateBank(bankName,bankUpdate);
    }

    public BankAccount updateIncreaseBankAccountBalance(String bankName, IncrementBalanceDto bodyIncrement){
        return this.bankPersistence.updateIncreaseBankAccountBalance(bankName,bodyIncrement);
    }
}
