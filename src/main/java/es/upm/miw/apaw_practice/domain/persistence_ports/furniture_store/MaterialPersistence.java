package es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store;

import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialPersistence {

    Material create(Material material);
    Material read(String name);
    boolean existName(String barcode);

}
