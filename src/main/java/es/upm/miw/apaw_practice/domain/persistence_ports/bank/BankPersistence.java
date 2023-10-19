package es.upm.miw.apaw_practice.domain.persistence_ports.bank;

import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import org.springframework.stereotype.Repository;

@Repository
public interface BankPersistence {

    Bank readByBankName(String bankName);
    Bank createBank(Bank bank);

    Bank updateBankCapital(Bank bank);
}
