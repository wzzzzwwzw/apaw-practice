package es.upm.miw.apaw_practice.adapters.mongodb.conference.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.PaperEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PaperRepository extends MongoRepository<PaperEntity, String> {
    Optional<PaperEntity> findByDigitalObjectIdentifier(String digitalObjectIdentifier);
}
