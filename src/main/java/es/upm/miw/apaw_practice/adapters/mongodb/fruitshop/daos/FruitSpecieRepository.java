package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitSpecieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface FruitSpecieRepository extends MongoRepository<FruitSpecieEntity, String>{
        Optional<FruitSpecieEntity> findBySpecie(String specie);
}
