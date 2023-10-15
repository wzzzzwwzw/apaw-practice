package es.upm.miw.apaw_practice.domain.services.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.Shelf;
import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.ShelfPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelfService {

    private final ShelfPersistence shelfPersistence;

    @Autowired
    public ShelfService(ShelfPersistence shelfPersistence) {
        this.shelfPersistence = shelfPersistence;
    }

    public Shelf update(String name, Shelf shelf) {
        return this.shelfPersistence.update(name, shelf);
    }
}