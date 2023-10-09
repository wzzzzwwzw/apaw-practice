package es.upm.miw.apaw_practice.domain.services.computer_store;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;
import es.upm.miw.apaw_practice.domain.persistence_ports.computer_store.WirePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WireService {
    private final WirePersistence wirePersistence;

    @Autowired
    public WireService(WirePersistence wirePersistence) {
        this.wirePersistence = wirePersistence;
    }

    public Wire read(String name) {
        return this.wirePersistence.read(name);
    }

    public Wire create(Wire wire) {
        this.assertWireNameNotExists(wire.getName());
        return this.wirePersistence.create(wire);
    }

    private void assertWireNameNotExists(String name) {
        if (this.wirePersistence.existWireName(name)) {
            throw new ConflictException("Wire name already exists: " + name);
        }
    }
}
