package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import org.springframework.stereotype.Repository;

@Repository
public interface MenuPersistence {

    void delete(String id);
}
