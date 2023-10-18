package es.upm.miw.apaw_practice.adapters.mongodb.swimming.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.ApprenticeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ApprenticeRepository extends MongoRepository <ApprenticeEntity, String>{
    Optional<ApprenticeEntity> findByForeName(String foreName);
}
