package es.upm.miw.apaw_practice.domain.services.stable;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.stable.Keeper;
import es.upm.miw.apaw_practice.domain.persistence_ports.stable.KeeperPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class KeeperService {
    private final KeeperPersistence keeperPersistence;
    @Autowired
    public KeeperService(KeeperPersistence keeperPersistence) {
        this.keeperPersistence = keeperPersistence;
    }

    public Keeper create(Keeper keeper) {
        keeper.setHireDate(LocalDate.now());
        this.assertNameNotExist(keeper.getName());
        return this.keeperPersistence.create(keeper);
    }
    public void assertNameNotExist(String name) {
        if (this.keeperPersistence.existName(name)) {
            throw new ConflictException("Name exist: " + name);
        }
    }
}
