package es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.CoffeeClient;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeClientPersistence {
    void delete(String name);

    CoffeeClient updateAddressByName(String name);
}
