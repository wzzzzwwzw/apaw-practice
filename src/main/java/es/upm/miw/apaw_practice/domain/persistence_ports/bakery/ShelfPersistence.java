package es.upm.miw.apaw_practice.domain.persistence_ports.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.Shelf;

import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

@Repository
public interface ShelfPersistence {

    Shelf update(String name, Shelf shelf);

    Stream<String> findUniqueLocationsByProductTypeCode(String code);
}
