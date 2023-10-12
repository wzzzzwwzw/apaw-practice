package es.upm.miw.apaw_practice.adapters.mongodb.conference.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.conference.daos.ConferenceLocationRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.daos.ConferenceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.ConferenceLocationEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.conference.ConferenceLocation;
import es.upm.miw.apaw_practice.domain.persistence_ports.conference.ConferenceLocationPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("conferenceLocationPersistence")
public class ConferenceLocationPersistenceMongodb implements ConferenceLocationPersistence {
    private final ConferenceLocationRepository conferenceLocationRepository;
    private final ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceLocationPersistenceMongodb(ConferenceLocationRepository conferenceLocationRepository, ConferenceRepository conferenceRepository) {
        this.conferenceLocationRepository = conferenceLocationRepository;
        this.conferenceRepository = conferenceRepository;
    }


    @Override
    public ConferenceLocation read(String id) {
        return this.conferenceLocationRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("ConferenceLocation id: " + id))
                .toConferenceLocation();

    }

    @Override
    public Stream<ConferenceLocation> readAll() {
        return this.conferenceLocationRepository.findAll().stream()
                .map(ConferenceLocationEntity::toConferenceLocation);
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

    @Override
    public Stream<String> findCitiesByAuthorHonorific(String honorific) {
        return this.conferenceRepository.findAll().stream()
                .filter(conferenceEntity -> conferenceEntity.getPapersEntities().stream()
                        .flatMap(paperEntity -> paperEntity.getAuthorEntities().stream())
                        .anyMatch(authorEntity -> honorific.equals(authorEntity.getHonorific())))
                .map(conferenceEntity -> conferenceEntity.getLocationEntity().getCity()).distinct();
    }
}
