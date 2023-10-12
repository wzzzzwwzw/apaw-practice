package es.upm.miw.apaw_practice.domain.services.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.Dining;
import es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop.DiningPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiningService {
    private final DiningPersistence diningPersistence;
    @Autowired
    public DiningService(DiningPersistence diningPersistence) {
        this.diningPersistence = diningPersistence;
    }
    public Dining Create(Dining dining) {
        return this.diningPersistence.create(dining);
    }
}
