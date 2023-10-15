package es.upm.miw.apaw_practice.adapters.mongodb.bakery.persistence;

import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.ShelfPersistence;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos.ShelfRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.ShelfEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.bakery.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("shelfPersistence")
public class ShelfPersistenceMongodb implements ShelfPersistence {
    
    private final ShelfRepository shelfRepository;

    @Autowired
    public ShelfPersistenceMongodb(ShelfRepository shelfRepository) {
        this.shelfRepository = shelfRepository;
    }

    @Override
    public Shelf update(String name, Shelf shelf) {
        ShelfEntity shelfEntity = this.shelfRepository
                .findByName(shelf.getName())
                .orElseThrow(() -> new NotFoundException("Shelf with name: " + shelf.getName()));
        shelfEntity.fromShelf(shelf);
        return this.shelfRepository
                .save(shelfEntity)
                .toShelf();
    }
}
