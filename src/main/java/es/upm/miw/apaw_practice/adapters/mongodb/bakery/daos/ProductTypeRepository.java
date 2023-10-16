package es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.ProductTypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductTypeRepository extends MongoRepository<ProductTypeEntity, String> {
    
}