package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.AquariumEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface AquariumRepository extends MongoRepository<AquariumEntity, String>{
    Optional<AquariumEntity> findByDescription(String description);
}
