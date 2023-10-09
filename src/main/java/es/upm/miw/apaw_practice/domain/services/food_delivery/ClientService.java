package es.upm.miw.apaw_practice.domain.services.food_delivery;


import es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery.ClientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientPersistence clientPersistence;

    @Autowired
    public ClientService(ClientPersistence clientPersistence){
        this.clientPersistence = clientPersistence;
    }

    public void delete(String identity){
        clientPersistence.delete(identity);
    }
}
