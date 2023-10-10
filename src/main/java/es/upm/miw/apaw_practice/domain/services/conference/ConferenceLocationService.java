package es.upm.miw.apaw_practice.domain.services.conference;

import es.upm.miw.apaw_practice.domain.models.conference.ConferenceLocation;
import es.upm.miw.apaw_practice.domain.persistence_ports.conference.ConferenceLocationPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ConferenceLocationService {

    private final ConferenceLocationPersistence conferenceLocationPersistence;

    @Autowired
    public ConferenceLocationService(ConferenceLocationPersistence conferenceLocationPersistence) {
        this.conferenceLocationPersistence = conferenceLocationPersistence;
    }

    public ConferenceLocation updateHall(String id, String hall) {
        ConferenceLocation conferenceLocation = conferenceLocationPersistence.read(id);
        conferenceLocation.setHall(hall);
        return conferenceLocationPersistence.update(id, conferenceLocation);
    }

    public Stream<String> findCitiesByAuthorHonorific(String honorific) {
        return null;
    }
}
