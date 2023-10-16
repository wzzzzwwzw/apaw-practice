package es.upm.miw.apaw_practice.adapters.mongodb.bakery.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos.ProductRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.ProductPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productPersistence")
public class ProductPersistenceMongodb implements ProductPersistence {
    
    private final ProductRepository productRepository;

    @Autowired
    public ProductPersistenceMongodb(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void delete(String name) {
        this.productRepository.deleteByName(name);
    }
}
