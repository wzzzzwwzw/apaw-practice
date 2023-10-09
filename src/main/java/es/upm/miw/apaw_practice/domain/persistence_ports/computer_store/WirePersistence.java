package es.upm.miw.apaw_practice.domain.persistence_ports.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;
import org.springframework.stereotype.Repository;

@Repository
public interface WirePersistence {
    Wire read(String name);

    boolean existWireName(String name);

    Wire create(Wire wire);
}
