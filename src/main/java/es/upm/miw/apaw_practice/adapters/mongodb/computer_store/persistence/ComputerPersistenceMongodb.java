package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos.ComputerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.ComputerEntity;
import es.upm.miw.apaw_practice.domain.models.computer_store.Computer;
import es.upm.miw.apaw_practice.domain.persistence_ports.computer_store.ComputerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

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

    @Override
    public Stream<Computer> findComputersStreamByJacketMaterial(String jacketMaterial) {
        return this.computerRepository.findAll()
                .stream()
                .map(ComputerEntity::toComputer)
                .filter(computer -> computer
                        .getMonitors()
                        .stream()
                        .anyMatch(monitor -> monitor
                                .getWires()
                                .stream()
                                .anyMatch(wire -> wire.getJacketMaterial().equals(jacketMaterial))
                        )
                );
    }


}
