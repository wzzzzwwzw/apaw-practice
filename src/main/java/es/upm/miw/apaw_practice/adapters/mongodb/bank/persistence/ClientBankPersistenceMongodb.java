package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.ClientBankRepository;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ClientBankEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;

import es.upm.miw.apaw_practice.domain.models.bank.ClientBank;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.ClientBankPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("clientBankPersistence")
public class ClientBankPersistenceMongodb implements ClientBankPersistence {

    private final ClientBankRepository clientBankRepository;


    @Autowired
    public ClientBankPersistenceMongodb(ClientBankRepository clientBankRepository) {
        this.clientBankRepository = clientBankRepository;
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
}
