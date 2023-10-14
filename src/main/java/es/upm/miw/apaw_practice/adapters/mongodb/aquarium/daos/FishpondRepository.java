package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.FishpondEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface FishpondRepository extends MongoRepository<FishpondEntity, String>{
    Optional<FishpondEntity> findByDirection(String direction);
}
