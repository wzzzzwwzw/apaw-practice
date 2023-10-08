package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.ZooRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.ZooPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("zooPersistence")
public class ZooPersistenceMongodb implements ZooPersistence {
    private final ZooRepository zooRepository;

    @Autowired
    public ZooPersistenceMongodb(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    @Override
    public void delete(String name) {
        this.zooRepository.deleteByName(name);

    }
}
