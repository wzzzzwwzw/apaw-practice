package es.upm.miw.apaw_practice.domain.persistence_ports.bank;

import es.upm.miw.apaw_practice.domain.models.bank.ClientBank;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientBankPersistence {
    ClientBank readByDni(String dni);
    void delete(String dni);
}
