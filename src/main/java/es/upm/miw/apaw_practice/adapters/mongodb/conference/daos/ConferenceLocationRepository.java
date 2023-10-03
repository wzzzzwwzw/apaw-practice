package es.upm.miw.apaw_practice.adapters.mongodb.conference.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.ConferenceLocationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConferenceLocationRepository extends MongoRepository<ConferenceLocationEntity, String> {
}
