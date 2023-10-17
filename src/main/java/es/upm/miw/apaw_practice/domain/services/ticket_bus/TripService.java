package es.upm.miw.apaw_practice.domain.services.ticket_bus;

import es.upm.miw.apaw_practice.domain.models.ticket_bus.Trip;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus.TripPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {
    private final TripPersistence tripPersistence;

    @Autowired
    public TripService(TripPersistence tripPersistence) {
        this.tripPersistence = tripPersistence;
    }

    public Trip readByPath(String path) {
        return this.tripPersistence.readByPath(path);
    }
}
