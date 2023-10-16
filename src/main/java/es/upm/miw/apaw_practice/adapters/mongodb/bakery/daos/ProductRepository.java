package es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {

    int deleteByName(String name);
}