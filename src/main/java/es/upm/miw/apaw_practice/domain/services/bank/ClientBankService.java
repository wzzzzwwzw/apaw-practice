package es.upm.miw.apaw_practice.domain.services.bank;


import es.upm.miw.apaw_practice.domain.models.bank.ClientBank;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.ClientBankPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientBankService {

    private final ClientBankPersistence clientBankPersistence;

    @Autowired
    public ClientBankService(ClientBankPersistence clientBankPersistence){
        this.clientBankPersistence=clientBankPersistence;
    }

    public ClientBank read(String dni){
        return this.clientBankPersistence.readByDni(dni);
    }
    public void delete(String dni){this.clientBankPersistence.delete(dni);}

    public List<String> findTypeNamesByDni(String dni){
        return this.clientBankPersistence.findTypeNamesByDni(dni);
    }
}
