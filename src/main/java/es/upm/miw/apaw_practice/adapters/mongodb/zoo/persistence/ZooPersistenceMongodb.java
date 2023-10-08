package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.ZooPersistence;
import org.springframework.stereotype.Repository;

@Repository("zooPersistence")
public class ZooPersistenceMongodb implements ZooPersistence {
    @Override
    public void delete(String name) {
        //TODO
    }
}
