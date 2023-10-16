package es.upm.miw.apaw_practice.domain.persistence_ports.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.Shelf;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfPersistence {

    Shelf update(String name, Shelf shelf);
}
