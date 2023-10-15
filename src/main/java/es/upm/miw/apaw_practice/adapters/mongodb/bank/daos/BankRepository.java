package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
public interface BankRepository extends MongoRepository<BankEntity,String>{
    Optional<BankEntity> findByBankName(String bankName);
}
