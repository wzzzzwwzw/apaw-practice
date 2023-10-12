package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.DiningEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DiningRepository extends MongoRepository<DiningEntity, String> {
    Optional<DiningEntity> findByDiningNumber(String diningNumber);
}
