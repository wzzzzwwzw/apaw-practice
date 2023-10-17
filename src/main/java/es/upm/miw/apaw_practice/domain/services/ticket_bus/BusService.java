package es.upm.miw.apaw_practice.domain.services.ticket_bus;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.Bus;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus.BusPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus.TripPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {
    private final BusPersistence busPersistence;
    private final TripPersistence tripPersistence;

    @Autowired
    public BusService(BusPersistence busPersistence, TripPersistence tripPersistence) {
        this.busPersistence = busPersistence;
        this.tripPersistence = tripPersistence;
    }

    public void createWithTripPath(String path, Bus bus) {
        this.assertReferenceBusNotExist(bus.getReferenceBus());
        bus.setTrip(this.tripPersistence.readByPath(path));
        this.busPersistence.create(bus);
    }

    public void assertReferenceBusNotExist(String busReference) {
        if (this.busPersistence.existReferenceBus(busReference)) {
            throw new ConflictException("Reference Bus exists: " + busReference);
        }
    }
}
