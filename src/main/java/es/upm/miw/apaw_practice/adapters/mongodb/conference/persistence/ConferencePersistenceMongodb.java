package es.upm.miw.apaw_practice.adapters.mongodb.conference.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.conference.daos.ConferenceRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.conference.ConferencePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("conferencePersistence")
public class ConferencePersistenceMongodb implements ConferencePersistence {
    private final ConferenceRepository conferenceRepository;

    @Autowired
    public ConferencePersistenceMongodb(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    public void delete(String id) {
        this.conferenceRepository.deleteById(id);
    }
}
