package es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store;

import es.upm.miw.apaw_practice.domain.models.furniture_store.Manager;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerPersistence {

    void delete(String affiliationNumber);
    Manager updateName(String affiliationNumber, String name);

}
