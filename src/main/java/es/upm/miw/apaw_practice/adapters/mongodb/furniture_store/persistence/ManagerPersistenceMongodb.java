package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos.ManagerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.ManagerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Manager;
import es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store.ManagerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("managerPersistence")
public class ManagerPersistenceMongodb implements ManagerPersistence {
    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerPersistenceMongodb(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public void delete(String affiliationNumber) {
        this.managerRepository.deleteByName(affiliationNumber);
    }

    @Override
    public Manager updateName(String affiliationNumber, String name) {
        ManagerEntity managerEntity = this.managerRepository
                .findByAffiliationNumber(affiliationNumber)
                .orElseThrow(() -> new NotFoundException("Manager affiliationNumber: " + affiliationNumber));
        managerEntity.setName(name);
        return this.managerRepository.save(managerEntity).toManager();
    }
}
