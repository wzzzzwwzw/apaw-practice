package es.upm.miw.apaw_practice.domain.services.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.Product;
import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.ProductPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {

    private final ProductPersistence productPersistence;

    @Autowired
    public ProductService(ProductPersistence productPersistence) {
        this.productPersistence = productPersistence;
    }

    public void delete(String name) {
        this.productPersistence.delete(name);
    }

    public Product updatePrice(String name, Double price) {
        Product product = this.productPersistence.findByName(name);
        product.setPrice(new BigDecimal(price));
        return this.productPersistence.update(product);
    }
}