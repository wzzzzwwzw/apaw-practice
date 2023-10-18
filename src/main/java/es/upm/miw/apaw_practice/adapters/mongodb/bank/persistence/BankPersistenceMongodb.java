package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankTypeEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository("bankPersistence")
public class BankPersistenceMongodb implements BankPersistence {

    private final BankRepository bankRepository;
    @Autowired
    public BankPersistenceMongodb( BankRepository bankRepository){
        this.bankRepository=bankRepository;
    }
    @Override
    public Bank readByBankName(String bankName) {
        return this.bankRepository.findByBankName(bankName)
                .orElseThrow(() -> new NotFoundException(" bankName: " + bankName))
                .toBank();
    }

    @Override
    public Bank createBank(Bank bank) {
        return this.bankRepository.save(new BankEntity(bank.getBankName(),bank.getLocation(),bank.getCapital(), new BankTypeEntity(bank.getBankType().getTypeName(),bank.getBankType().getDescription(),bank.getBankType().getMinimunCapital()))).toBank();
    }


}
