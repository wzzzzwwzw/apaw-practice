package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos.DiningRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.DiningEntity;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Dining;
import es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop.DiningPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("diningPersistence")
public class DiningPersistenceMongodb implements DiningPersistence {
    private final DiningRepository diningRepository;

    @Autowired
    public DiningPersistenceMongodb(DiningRepository diningRepository) {
        this.diningRepository = diningRepository;
    }

    @Override
    public Dining create(Dining dining) {
        return this.diningRepository
                .save(new DiningEntity(dining))
                .toDining();
    }
}
