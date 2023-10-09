package es.upm.miw.apaw_practice.domain.persistence_ports.conference;

import es.upm.miw.apaw_practice.domain.models.conference.ConferenceLocation;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ConferenceLocationPersistence {
    ConferenceLocation read(String id);

    Stream<ConferenceLocation> readAll();
    ConferenceLocation update(String id, ConferenceLocation conferenceLocation);
}
