package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.ZooRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.ZooEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.zoo.Zoo;
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

    @Override
    public Zoo read(String name) {
        return zooRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Zoo Name: " + name))
                .toZoo();
    }

    @Override
    public void update(String name, Zoo zoo) {
        ZooEntity zooEntity = this.zooRepository
                .findByName(zoo.getName())
                .orElseThrow(() -> new NotFoundException("Zoo Name: " + zoo.getName()));

        zooEntity.setTicketPrice(zoo.getTicketPrice());
        this.zooRepository
            .save(zooEntity);
    }
}
