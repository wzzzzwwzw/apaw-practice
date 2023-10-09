package es.upm.miw.apaw_practice.domain.services.computer_store;

import es.upm.miw.apaw_practice.domain.persistence_ports.computer_store.ComputerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerService {
    private final ComputerPersistence computerPersistence;

    @Autowired
    public ComputerService(ComputerPersistence computerPersistence) {
        this.computerPersistence = computerPersistence;
    }

    public void delete(String name) {
        this.computerPersistence.delete(name);
    }
}
