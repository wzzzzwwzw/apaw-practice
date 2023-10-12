package es.upm.miw.apaw_practice.domain.persistence_ports.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.Computer;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ComputerPersistence {
    void delete(String name);

    Stream<Computer> findComputersStreamByJacketMaterial(String jacketMaterial);
}
