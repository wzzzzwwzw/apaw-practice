package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankTypeRepository;
import es.upm.miw.apaw_practice.domain.models.bank.BankType;
import org.springframework.stereotype.Repository;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankTypePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
@Repository("bankTypePersistence")
public class BankTypePersistenceMongodb implements BankTypePersistence {

    private final BankTypeRepository bankTypeRepository;

    @Autowired
    public BankTypePersistenceMongodb(BankTypeRepository bankTypeRepository){
        this.bankTypeRepository=bankTypeRepository;
    }

    @Override
    public BankType readByTypeName(String typeName) {
        return this.bankTypeRepository.findByTypeName(typeName)
                .orElseThrow(() -> new NotFoundException(" Bank Type name: " + typeName))
                .toBankType();
    }
}
