package es.upm.miw.apaw_practice.domain.services.bank;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankTypePersistence;
import es.upm.miw.apaw_practice.domain.models.bank.BankType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankTypeService {

    private final BankTypePersistence bankTypePersistence;
    @Autowired
    public BankTypeService(BankTypePersistence bankTypePersistence){
        this.bankTypePersistence=bankTypePersistence;
    }

    public BankType read(String typeName){
        return this.bankTypePersistence.readByTypeName(typeName);
    }

    public BigDecimal obtainSumOfBalanceByDescription(String description){
        return this.bankTypePersistence.obtainSumOfBalanceByDescription(description);
    }

}
