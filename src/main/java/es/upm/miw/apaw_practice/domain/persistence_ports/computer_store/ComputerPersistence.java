package es.upm.miw.apaw_practice.domain.persistence_ports.computer_store;

import org.springframework.stereotype.Repository;

@Repository
public interface ComputerPersistence {
    void delete(String name);
}
