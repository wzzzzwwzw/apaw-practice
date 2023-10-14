package es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store;

import org.springframework.stereotype.Repository;

@Repository
public interface ManagerPersistence {

    void delete(String name);

}
