package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.TripRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.Trip;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus.TripPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tripPersistence")
public class TripPersistenceMongodb implements TripPersistence {
    private final TripRepository tripRepository;

    @Autowired
    public TripPersistenceMongodb(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Trip readByPath(String path) {
        return this.tripRepository.findByPath(path)
                .orElseThrow(() -> new NotFoundException("Trip path: " + path))
                .toTrip();
    }
}
