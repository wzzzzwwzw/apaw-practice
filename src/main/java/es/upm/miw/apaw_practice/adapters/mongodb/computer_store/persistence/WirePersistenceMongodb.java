package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos.WireRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.WireEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;
import es.upm.miw.apaw_practice.domain.persistence_ports.computer_store.WirePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("wirePersistence")
public class WirePersistenceMongodb implements WirePersistence {
    private final WireRepository wireRepository;

    @Autowired
    public WirePersistenceMongodb(WireRepository wireRepository) {
        this.wireRepository = wireRepository;
    }

    @Override
    public Wire read(String name) {
        return this.wireRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Wire name: " + name))
                .toWire();
    }

    @Override
    public boolean existsWireName(String name) {
        return this.wireRepository
                .findByName(name)
                .isPresent();
    }

    @Override
    public Wire create(Wire wire) {
        return this.wireRepository
                .save(new WireEntity(wire))
                .toWire();
    }
}
