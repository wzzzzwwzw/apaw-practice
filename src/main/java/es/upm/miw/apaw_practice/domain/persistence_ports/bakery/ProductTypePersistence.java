package es.upm.miw.apaw_practice.domain.persistence_ports.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.ProductType;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypePersistence {

    ProductType findByCode(String code);
}
