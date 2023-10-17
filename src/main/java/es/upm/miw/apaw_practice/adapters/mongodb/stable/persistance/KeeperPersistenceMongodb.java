package es.upm.miw.apaw_practice.adapters.mongodb.stable.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.stable.daos.KeeperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.KeeperEntity;
import es.upm.miw.apaw_practice.domain.models.stable.Keeper;
import es.upm.miw.apaw_practice.domain.persistence_ports.stable.KeeperPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("keeperPersistence")
public class KeeperPersistenceMongodb implements KeeperPersistence {
    private final KeeperRepository keeperRepository;
    @Autowired
    public KeeperPersistenceMongodb(KeeperRepository keeperRepository) {
        this.keeperRepository = keeperRepository;
    }
    @Override
    public Keeper create(Keeper keeper) {
        return this.keeperRepository
                .save(new KeeperEntity(keeper))
                .toKeeper();
    }
    @Override
    public boolean existName(String name) {
        return this.keeperRepository
                .findByName(name)
                .isPresent();
    }
}
