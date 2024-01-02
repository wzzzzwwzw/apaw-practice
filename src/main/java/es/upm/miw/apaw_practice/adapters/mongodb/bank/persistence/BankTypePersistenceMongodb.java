package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankTypeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankAccountEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankTypeEntity;
import es.upm.miw.apaw_practice.domain.models.bank.BankType;
import org.springframework.stereotype.Repository;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankTypePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Repository("bankTypePersistence")
public class BankTypePersistenceMongodb implements BankTypePersistence {

    private final BankTypeRepository bankTypeRepository;
    private final BankRepository bankRepository;

    @Autowired
    public BankTypePersistenceMongodb(BankTypeRepository bankTypeRepository,BankRepository bankRepository){
        this.bankTypeRepository=bankTypeRepository;
        this.bankRepository=bankRepository;
    }

    @Override
    public BankType readByTypeName(String typeName) {
        return this.bankTypeRepository.findByTypeName(typeName)
                .orElseThrow(() -> new NotFoundException(" Bank Type name: " + typeName))
                .toBankType();
    }
    @Override
    public BigDecimal obtainSumOfBalanceByDescription(String description){
        List<BankTypeEntity> bankTypesList = this.bankTypeRepository
                .findAll()
                .stream()
                .filter(bankType -> bankType.getDescription().equals(description))
                .toList();

        return this.bankRepository
                .findAll()
                .stream()
                .filter(bankEntity -> bankTypesList.contains(bankEntity.getBankTypeEntity()))
                .flatMap(bankEntity -> bankEntity.getBankAccountEntityList().stream())
                .map(BankAccountEntity::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


    }
}
