package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitShopEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface FruitShopRepository extends MongoRepository<FruitShopEntity, String> {
    Optional<FruitShopEntity> findByName(String name);
}
