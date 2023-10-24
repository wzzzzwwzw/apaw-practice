package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.ClientBankRepository;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankAccountEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankTypeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ClientBankEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;

import es.upm.miw.apaw_practice.domain.models.bank.ClientBank;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.ClientBankPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository("clientBankPersistence")
public class ClientBankPersistenceMongodb implements ClientBankPersistence {

    private final ClientBankRepository clientBankRepository;

    private final BankRepository bankRepository;
    @Autowired
    public ClientBankPersistenceMongodb(ClientBankRepository clientBankRepository,BankRepository bankRepository) {
        this.clientBankRepository = clientBankRepository;
        this.bankRepository=bankRepository;
    }
    @Override
    public ClientBank readByDni(String dni){
        return this.clientBankRepository.findByDni(dni)
                .orElseThrow(() -> new NotFoundException(" dni: " + dni))
                .toClientBank();
    }
    @Override
    public void delete(String dni) {
        Optional<ClientBankEntity> clientBankEntity = this.clientBankRepository.findByDni(dni);
        if(clientBankEntity.isPresent()){
            clientBankRepository.delete(clientBankEntity.get());
        }
        else{
            throw new NotFoundException("Inexistente: " + dni);
        }

    }

    @Override
    public List<String> findTypeNamesByDni(String dni) {
        return clientBankRepository.findByDni(dni)
                .map(ClientBankEntity::getListAccountsEntities)
                .orElseThrow(() -> new NotFoundException("Cliente no encontrado para DNI: " + dni))
                .stream()
                .flatMap(account -> bankRepository.findAll().stream()
                        .filter(bank -> bank.getBankAccountEntityList().contains(account))
                        .map(BankEntity::getBankTypeEntity)
                        .map(BankTypeEntity::getTypeName))
                .distinct()
                .toList();

    }
}
