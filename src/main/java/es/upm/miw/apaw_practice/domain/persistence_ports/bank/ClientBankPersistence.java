package es.upm.miw.apaw_practice.domain.persistence_ports.bank;

import es.upm.miw.apaw_practice.domain.models.bank.ClientBank;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientBankPersistence {
    ClientBank readByDni(String dni);
    void delete(String dni);

    List<String> findTypeNamesByDni(String dni);
}
