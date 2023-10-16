package es.upm.miw.apaw_practice.adapters.mongodb.bakery.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos.ProductRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.ProductEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.bakery.Product;
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

    @Override
    public Product findByName(String name) {
        ProductEntity productEntity = this.productRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Product with name: " + name));
        return productEntity.toProduct();
    }

    @Override
    public Product update(Product product) {
        ProductEntity productEntity = this.productRepository
                .findByName(product.getName())
                .orElseThrow(() -> new NotFoundException("Product with name: " + product.getName()));
        productEntity.fromProduct(product);
        return this.productRepository
                .save(productEntity)
                .toProduct();
    }
}
