package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerEntity, Integer> {
    Optional<CustomerEntity> findByIdCustomer(Integer idCustomer);
}
