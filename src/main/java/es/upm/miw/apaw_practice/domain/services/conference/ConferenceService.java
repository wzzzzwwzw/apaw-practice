package es.upm.miw.apaw_practice.domain.services.conference;

import es.upm.miw.apaw_practice.domain.persistence_ports.conference.ConferencePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService {

    private final ConferencePersistence conferencePersistence;

    @Autowired
    public ConferenceService(ConferencePersistence conferencePersistence) {
        this.conferencePersistence = conferencePersistence;
    }

    public void delete(String id) {
        this.conferencePersistence.delete(id);
    }
}
