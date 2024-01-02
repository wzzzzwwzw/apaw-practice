package es.upm.miw.apaw_practice.domain.persistence_ports.bank;
import org.springframework.stereotype.Repository;

import es.upm.miw.apaw_practice.domain.models.bank.BankType;

import java.math.BigDecimal;

@Repository
public interface BankTypePersistence {

    BankType readByTypeName(String typeName);

    BigDecimal obtainSumOfBalanceByDescription(String description);

}
