package es.upm.miw.apaw_practice.domain.services.furniture_store;

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

    public void delete(String name) {
        this.managerPersistence.delete(name);
    }
}
