package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.AquariumCuratorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface AquariumCuratorRepository extends MongoRepository<AquariumCuratorEntity, String>{
    Optional<AquariumCuratorEntity> findByName(String name);
}
