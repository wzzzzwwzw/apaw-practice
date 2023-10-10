package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos.ComputerRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.computer_store.ComputerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("computerPersistence")
public class ComputerPersistenceMongodb implements ComputerPersistence {
    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerPersistenceMongodb(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public void delete(String name) {
        this.computerRepository.deleteByName(name);
    }
}
