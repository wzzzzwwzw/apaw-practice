package es.upm.miw.apaw_practice.adapters.mongodb.conference.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.conference.daos.ConferenceLocationRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.ConferenceLocationEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.conference.ConferenceLocation;
import es.upm.miw.apaw_practice.domain.persistence_ports.conference.ConferenceLocationPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("conferenceLocationPersistence")
public class ConferenceLocationPersistenceMongodb implements ConferenceLocationPersistence {
    private final ConferenceLocationRepository conferenceLocationRepository;

    @Autowired
    public ConferenceLocationPersistenceMongodb(ConferenceLocationRepository conferenceLocationRepository) {
        this.conferenceLocationRepository = conferenceLocationRepository;
    }


    @Override
    public ConferenceLocation read(String id) {
        return this.conferenceLocationRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("ConferenceLocation id: " + id))
                .toConferenceLocation();

    }

    @Override
    public ConferenceLocation update(String id, ConferenceLocation conferenceLocation) {
        ConferenceLocationEntity conferenceLocationEntity = this.conferenceLocationRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("ConferenceLocation id: " + id));
        conferenceLocationEntity.fromConferenceLocation(conferenceLocation);
        return this.conferenceLocationRepository
                .save(conferenceLocationEntity)
                .toConferenceLocation();
    }
}
