package es.upm.miw.apaw_practice.domain.services.furniture_store;

import es.upm.miw.apaw_practice.domain.models.furniture_store.Manager;
import es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store.ManagerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private final ManagerPersistence managerPersistence;

    @Autowired
    public ManagerService(ManagerPersistence managerPersistence) {
        this.managerPersistence = managerPersistence;
    }

    public void delete(String affiliationNumber) {
        this.managerPersistence.delete(affiliationNumber);
    }

    public Manager updateName(String affiliationNumber, String name) {
        return this.managerPersistence.updateName(affiliationNumber, name);
    }

}
