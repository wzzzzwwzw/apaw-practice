package es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop;

import org.springframework.stereotype.Repository;

@Repository
public interface FruitShopPersistence {
    void delete(String name);
}
