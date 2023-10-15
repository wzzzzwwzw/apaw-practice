package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ClientBankEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
public interface ClientBankRepository extends MongoRepository<ClientBankEntity,String>{
    Optional<ClientBankEntity> findByDni(String dni);
}
