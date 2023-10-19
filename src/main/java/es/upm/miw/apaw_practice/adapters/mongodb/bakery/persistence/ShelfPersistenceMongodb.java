package es.upm.miw.apaw_practice.adapters.mongodb.bakery.persistence;

import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.ShelfPersistence;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos.ShelfRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.ShelfEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.bakery.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

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
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Shelf with name: " + shelf.getName()));
        shelfEntity.fromShelf(shelf);
        return this.shelfRepository
                .save(shelfEntity)
                .toShelf();
    }

    @Override
    public Stream<String> findUniqueLocationsByProductTypeCode(String code) {
        return this.shelfRepository.findAll().stream()
                .filter(shelf -> shelf.getProducts().stream()
                        .anyMatch(product -> code.equals(product.getProductType().getCode())))
                .map(ShelfEntity::getLocation)
                .distinct();
    }
}
