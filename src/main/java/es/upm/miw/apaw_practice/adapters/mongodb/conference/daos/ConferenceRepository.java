package es.upm.miw.apaw_practice.adapters.mongodb.conference.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.ConferenceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConferenceRepository extends MongoRepository<ConferenceEntity, String> {
}
