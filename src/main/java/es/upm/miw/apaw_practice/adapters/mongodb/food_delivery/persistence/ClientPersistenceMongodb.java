package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos.ClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.ClientEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery.ClientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository("clientPersistence")
public class ClientPersistenceMongodb implements ClientPersistence {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientPersistenceMongodb(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    @Override
    public void delete(String identity) {
        Optional<ClientEntity> clientEntity = this.clientRepository.findByIdentity(identity);
        if(clientEntity.isPresent()){
            clientRepository.delete(clientEntity.get());
        }
        else{
            throw new NotFoundException("Client identty: " + identity);
        }

    }
}
