package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.FishpondEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.FishEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;
public interface FishpondRepository extends MongoRepository<FishpondEntity, String>{
    Optional<FishpondEntity> findByDirection(String direction);

    void deleteByDirection(String direction);
    public interface FishRepository extends MongoRepository<FishEntity, String> {
        int deleteByDerection(String direction);
    }
}
