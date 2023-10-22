package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankAccountEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankTypeEntity;


import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.bank.Bank;

import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


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
    public Bank updateBank(String bankName,Bank bankUpdated) {
        BankEntity bankEntity = this.bankRepository
                .findByBankName(bankName)
                .orElseThrow(() -> new NotFoundException("Bank name:" + bankName));
        bankEntity.setBankName(bankUpdated.getBankName());
        bankEntity.setCapital(bankUpdated.getCapital());
        bankEntity.setLocation(bankUpdated.getLocation());
        bankEntity.setBankTypeEntity(new BankTypeEntity(bankUpdated.getBankType().getTypeName(),bankUpdated.getBankType().getDescription(),bankUpdated.getBankType().getMinimunCapital()));
        List<BankAccountEntity> updatedBankAccountList=bankUpdated.getListAccounts()
                .stream()
                .map(bankAccount -> new BankAccountEntity(bankAccount.getNumAccount(),bankAccount.getExpiration(),bankAccount.getCvv(),bankAccount.getBalance())).collect(Collectors.toList());
        bankEntity.setBankAccountEntityList(updatedBankAccountList);
        System.out.println(bankEntity);
        return this.bankRepository
                .save(bankEntity)
                .toBank();
    }


    @Override
    public BankAccount updateIncreaseBankAccountBalance(String bankName , String numAccount, BigDecimal increment){
        BankEntity bankEntity=this.bankRepository.findByBankName(bankName)
                .orElseThrow(() -> new NotFoundException(" bankName: " + bankName));
        List<BankAccountEntity> bankAccountEntities=bankEntity.getBankAccountEntityList();

        BankAccountEntity bankAccountEntity=bankAccountEntities.stream()
                .filter(accountEntity -> numAccount.equals(accountEntity.getNumAccount()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Cuenta no encontrada con número: " + numAccount));

        bankAccountEntities.remove(bankAccountEntity);
        bankAccountEntity.setBalance(bankAccountEntity.getBalance().add(increment));
        bankAccountEntities.add(bankAccountEntity);

        bankEntity.setBankAccountEntityList(bankAccountEntities);


        this.bankRepository.save(bankEntity);
        return bankAccountEntity.toBankAccount();
    }
}
