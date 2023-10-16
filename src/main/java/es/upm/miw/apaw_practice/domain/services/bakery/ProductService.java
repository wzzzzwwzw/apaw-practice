package es.upm.miw.apaw_practice.domain.services.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.Product;
import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.ProductPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductPersistence productPersistence;

    @Autowired
    public ProductService(ProductPersistence productPersistence) {
        this.productPersistence = productPersistence;
    }

    public void delete(String name) {
        return this.productPersistence.delete(name);
    }

}