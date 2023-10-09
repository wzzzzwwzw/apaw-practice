package es.upm.miw.apaw_practice.domain.persistence_ports.conference;

import es.upm.miw.apaw_practice.domain.models.conference.ConferenceLocation;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceLocationPersistence {
    ConferenceLocation read(String id);
    ConferenceLocation update(String id, ConferenceLocation conferenceLocation);
}
