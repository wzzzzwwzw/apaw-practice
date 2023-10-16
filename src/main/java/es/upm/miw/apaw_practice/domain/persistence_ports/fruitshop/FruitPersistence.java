package es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop;

import es.upm.miw.apaw_practice.domain.models.fruitShop.Fruit;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface FruitPersistence {
    Fruit readByType(String type);

    Fruit update(Fruit fruit);

    Stream<Fruit> readAll();
}
