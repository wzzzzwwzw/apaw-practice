package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankTypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
public interface BankTypeRepository extends MongoRepository<BankTypeEntity,String>{
    Optional<BankTypeEntity> findByTypeName(String typeName);
}
