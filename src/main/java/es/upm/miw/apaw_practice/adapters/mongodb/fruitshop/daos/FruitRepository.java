package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface FruitRepository extends MongoRepository<FruitEntity, String>{
    Optional<FruitEntity> findByType(String type);

}
