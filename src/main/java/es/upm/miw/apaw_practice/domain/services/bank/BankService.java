package es.upm.miw.apaw_practice.domain.services.bank;

import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
