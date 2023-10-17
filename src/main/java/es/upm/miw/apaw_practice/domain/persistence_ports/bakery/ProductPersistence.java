package es.upm.miw.apaw_practice.domain.persistence_ports.bakery;

import org.springframework.stereotype.Repository;
import es.upm.miw.apaw_practice.domain.models.bakery.Product;

@Repository
public interface ProductPersistence {

    void delete(String name);

    Product update(Product product);

    Product findByName(String name);
}
