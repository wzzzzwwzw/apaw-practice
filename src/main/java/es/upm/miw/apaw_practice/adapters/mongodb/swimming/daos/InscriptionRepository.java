package es.upm.miw.apaw_practice.adapters.mongodb.swimming.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.InscriptionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InscriptionRepository extends MongoRepository<InscriptionEntity, String> {

    Optional<InscriptionEntity> findByInscriptionNumber(String inscriptionNumber);
}
