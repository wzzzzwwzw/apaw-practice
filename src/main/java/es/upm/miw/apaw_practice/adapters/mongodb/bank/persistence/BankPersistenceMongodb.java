package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankAccountEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankTypeEntity;

import es.upm.miw.apaw_practice.adapters.rest.bank.dto.IncrementBalanceDto;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.bank.Bank;

import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


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

    @Override
    public Bank updateBankCapital(Bank bank) {
        BankEntity bankEntity = this.bankRepository
                .findByBankName(bank.getBankName())
                .orElseThrow(() -> new NotFoundException("Bank name:" + bank.getBankName()));

        bankEntity.setCapital(bank.getCapital());
        return this.bankRepository
                .save(bankEntity)
                .toBank();
    }
    @Override
    public BankAccount updateIncreaseBankAccountBalance(String bankName , IncrementBalanceDto bodyIncrement){
        BankEntity bankEntity=this.bankRepository.findByBankName(bankName)
                .orElseThrow(() -> new NotFoundException(" bankName: " + bankName));
        List<BankAccountEntity> bankAccountEntities=bankEntity.getBankAccountEntityList();

        BankAccountEntity bankAccountEntity=bankAccountEntities
                .stream()
                .filter(accountEntity -> accountEntity.getNumAccount().equals(bodyIncrement.getNumAccount()))
                .findFirst().orElseThrow(() -> new NotFoundException("Cuenta con numAccount: " + bodyIncrement.getNumAccount() + " no encontrada en la lista de cuentas del banco."));

        bankAccountEntities.remove(bankAccountEntity);
        bankAccountEntity.setBalance(bankAccountEntity.getBalance().add(bodyIncrement.getIncrement()));
        bankAccountEntities.add(bankAccountEntity);

        bankEntity.setBankAccountEntityList(bankAccountEntities);


        this.bankRepository.save(bankEntity);
        return bankAccountEntity.toBankAccount();
    }
}
