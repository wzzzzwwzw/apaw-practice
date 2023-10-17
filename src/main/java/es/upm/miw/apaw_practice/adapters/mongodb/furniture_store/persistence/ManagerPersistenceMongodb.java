package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos.ManagerRepository;
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
}
